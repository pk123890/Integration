package io.swagger.velocityTemplate;

import io.swagger.IntegrationName;
import org.apache.commons.io.IOUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class VelocityTemplate {
  public static void main(String[] args) throws Exception {
    VelocityEngine velocityEngine = new VelocityEngine();
    velocityEngine.init();

    IntegrationName integrationName = new IntegrationName();
    Field[] fieldList = integrationName.getClass().getFields();

    for (Field iterator : fieldList) {

      //Script to generate  CONTROLLER CODE(IntegrationNameAPI.java).
      Template controllerTemplate = velocityEngine.getTemplate("java.templateController.vm");
      VelocityContext controllerContext = new VelocityContext();
      StringWriter controllerWriter = new StringWriter();

      String integrateString = IOUtils.toString(new FileReader(
          new File("src/main/java/io/swagger/api/" + iterator.get(integrationName) + "Api.java")));

      controllerContext.put("NameApi", iterator.get(integrationName) + "Api");
      controllerContext.put("NameApiController", iterator.get(integrationName) + "ApiController");
      controllerContext.put("NameApiControllerclass",iterator.get(integrationName) + "ApiController.class");
      controllerContext.put("Proxy", iterator.get(integrationName) + "Proxy");
      controllerContext
          .put("proxyname", ((String) iterator.get(integrationName)).toLowerCase() + "Proxy;\n");

      Class className =
          Class.forName("io.swagger.api." + iterator.get(integrationName) + "ApiController");


      //Script to generate  PROXY CODE(IntegrationNameProxy.java).
      Template proxyTemplate = velocityEngine.getTemplate("java.templateProxy.vm");
      VelocityContext proxyContext = new VelocityContext();
      StringWriter proxyWriter = new StringWriter();

      FileWriter proxyFileWriter = new FileWriter(
          new File("src/main/java/io/swagger/api/" + iterator.get(integrationName) + "Proxy.java"));

      proxyContext
          .put("proxyname", "\"" + ((String) iterator.get(integrationName)).toLowerCase() + "\"");
      proxyContext.put("Proxy", iterator.get(integrationName) + "Proxy");
      Class[] classNameInterfaces = className.getInterfaces();


      Method[] methodList = className.getMethods();
      StringBuilder stringBuilderIntegrate = new StringBuilder();
      StringBuilder stringBuilderProxy = new StringBuilder();
      int i = 0;


      //TO Generate Controller as well as Proxy APIs for a specific Integration.
      for (Method method : methodList) {

        Template integrationTemplate = velocityEngine.getTemplate("IntegrationData.vm");
        VelocityContext integrationContext = new VelocityContext();
        StringWriter integrationWriter = new StringWriter();

        StringBuilder stringBuilderParameter = new StringBuilder();
        StringBuilder stringBuilderFunctionParameter = new StringBuilder();
        StringBuilder stringBuilderProxyFunctionParameter = new StringBuilder();

        Template proxyDataTemplate = velocityEngine.getTemplate("ProxyData.vm");
        VelocityContext proxyDataContent = new VelocityContext();
        StringWriter proxyDataWriter = new StringWriter();

        integrationContext.put("functionName", method.getName());


        String mapping =
            ((RequestMapping) classNameInterfaces[0].getMethods()[0].getAnnotations()[2])
                .method()[0].toString().toLowerCase();

        proxyDataContent.put("MappingType",
            "@" + mapping.substring(0, 1).toUpperCase() + mapping.substring(1) + "Mapping");

        proxyDataContent.put("APIname", method.getName());

        if (method.getName().contains(((String) iterator.get(integrationName)).toLowerCase())) {

          Parameter[] parameters = method.getParameters();
          int j = 0;

          //If there are some parameters for the API
          if (parameters.length != 0) {
            integrationContext.put("integrationspecific",
                "return new ResponseEntity<String>(" + ((String) iterator.get(integrationName))
                    .toLowerCase() + "Proxy." + method.getName());


            for (Parameter parameter : parameters) {
              Template parameterDataTemplate = velocityEngine.getTemplate("ParameterData.vm");
              VelocityContext parameterDataContext = new VelocityContext();
              StringWriter parameterDataWriter = new StringWriter();

              Template functionParameterTemplate =
                  velocityEngine.getTemplate("FunctionParameterData.vm");
              VelocityContext functionParameterContext = new VelocityContext();
              StringWriter functionParameterWriter = new StringWriter();

              Template proxyParameterDataTemplate =
                  velocityEngine.getTemplate("ProxyParameterData.vm");
              VelocityContext proxyParameterDataContext = new VelocityContext();
              StringWriter proxyParameterDataWriter = new StringWriter();


              if (j > 0) {
                stringBuilderParameter.append(",");
                stringBuilderFunctionParameter.append(",");
                stringBuilderProxyFunctionParameter.append(",");
              }
              parameterDataContext
                  .put("parameterdata", ((RequestParam) parameter.getAnnotations()[2]).value());

              parameterDataContext.put("parameter",
                  parameter.getParameterizedType().getTypeName() + " " + ((RequestParam) parameter
                      .getAnnotations()[2]).value());

              functionParameterContext
                  .put("functionParameter", ((RequestParam) parameter.getAnnotations()[2]).value());

              proxyParameterDataContext.put("proxyFunctionParameter",
                  "@RequestParam(\"" + ((RequestParam) parameter.getAnnotations()[2]).value()
                      + "\") " + parameter.getParameterizedType().getTypeName() + " "
                      + ((RequestParam) parameter.getAnnotations()[2]).value());
              parameterDataTemplate.merge(parameterDataContext, parameterDataWriter);

              stringBuilderParameter.append(parameterDataWriter.toString());

              functionParameterTemplate.merge(functionParameterContext, functionParameterWriter);

              stringBuilderFunctionParameter.append(functionParameterWriter.toString());

              proxyParameterDataTemplate.merge(proxyParameterDataContext,proxyParameterDataWriter);

              stringBuilderProxyFunctionParameter.append(proxyParameterDataWriter.toString());
              j++;
            }

            integrationContext.put("parameter", stringBuilderParameter.toString());
            integrationContext.put("functionParameter", stringBuilderFunctionParameter.toString());


            proxyDataContent.put("parameter", stringBuilderProxyFunctionParameter.toString());
            proxyDataContent.put("path",
                "\"" + ((RequestMapping) classNameInterfaces[0].getMethods()[i].getAnnotations()[2])
                    .value()[0] + "\"");

            i++;

          }
          //ELSE if there are no parameters for the API.

          else {

            integrationContext.put("parameter", "");

            integrationContext.put("functionParameter", "");


            integrationContext.put("integrationspecific",
                "return new ResponseEntity<String>(" + ((String) iterator.get(integrationName))
                    .toLowerCase() + "Proxy." + method.getName());

            proxyDataContent.put("path",
                "\"" + ((RequestMapping) classNameInterfaces[0].getMethods()[i].getAnnotations()[2])
                    .value()[0] + "\"");
            i++;
            proxyDataContent.put("parameter", "");
          }
          integrationTemplate.merge(integrationContext, integrationWriter);
          stringBuilderIntegrate.append(integrationWriter.toString());
          stringBuilderIntegrate.append("\n");

          proxyDataTemplate.merge(proxyDataContent, proxyDataWriter);
          stringBuilderProxy.append(proxyDataWriter.toString());
          stringBuilderProxy.append("\n");
        } else {
          break;
        }
      }
      controllerContext.put("integrationData", stringBuilderIntegrate.toString());

      proxyContext.put("Data", stringBuilderProxy.toString());
      proxyTemplate.merge(proxyContext, proxyWriter);
      proxyFileWriter.write(proxyWriter.toString());
      proxyFileWriter.close();

      //To generate controller
      FileWriter fooWriter = new FileWriter(new File(
          "src/main/java/io/swagger/api/" + iterator.get(integrationName) + "ApiController.java"),
          false);
      controllerTemplate.merge(controllerContext, controllerWriter);
      fooWriter.write(controllerWriter.toString());
      fooWriter.close();


      FileWriter integrateFile = new FileWriter(
          new File("src/main/java/io/swagger/api/" + iterator.get(integrationName) + "Api.java"),
          false);
      integrateString = integrateString.replaceAll("Void", "String");
      integrateFile.write(integrateString);
      integrateFile.close();

    }


  }
}
