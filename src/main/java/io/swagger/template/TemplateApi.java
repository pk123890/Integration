package io.swagger.template;

import io.swagger.IntegrationName;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;


//TO GENERATE THE CONTROLLER AND PROXY CODE FROM THE TEMPLATE FILES: TemplateName.java & TemplateProxyName.java in THE SPRING PROJECT



public class TemplateApi {
    public static void main(String[] args) throws Exception {

        IntegrationName integrationName = new IntegrationName();
        Field[] fieldList = integrationName.getClass().getFields();

        for (Field iterator : fieldList) {

            //Script to generate  CONTROLLER CODE(IntegrationNameAPI.java).
            String content = IOUtils.toString(new FileReader(new File("TemplateName.java")));
            FileWriter fileWriter = new FileWriter(new File(iterator.get(integrationName) + "ApiController.java"));
            String integration = IOUtils.toString(new FileReader(new File("IntegrationData.txt")));
            String integrateString = IOUtils.toString(new FileReader(new File("/Users/prateekkoul/Documents/spring-server-generated (1) copy/src/main/java/io/swagger/api/"+iterator.get(integrationName)+"Api.java")));
            String parameterData = IOUtils.toString(new FileReader(new File("ParameterData.txt")));
            content = content.replaceAll("Name", (String) iterator.get(integrationName));
            content=content.replaceAll("Proxy", iterator.get(integrationName)+"Proxy");
            content=content.replaceAll("proxyname",((String) iterator.get(integrationName)).toLowerCase() + "Proxy;\n");
            Class className = Class.forName("io.swagger.api." + iterator.get(integrationName) + "ApiController");

            //Script to generate  PROXY CODE(IntegrationNameProxy.java).
            String proxyContent = IOUtils.toString(new FileReader(new File("TemplateProxyName.java")));
            FileWriter proxyFileWriter = new FileWriter(new File("/Users/prateekkoul/Documents/spring-server-generated (1) copy/src/main/java/io/swagger/api/"+iterator.get(integrationName) + "Proxy.java"));
            String proxyData = IOUtils.toString(new FileReader(new File("ProxyData.txt")));
            proxyContent=proxyContent.replaceAll("proxyname","\""+((String) iterator.get(integrationName)).toLowerCase()+"\"");
            proxyContent=proxyContent.replaceAll("Proxy",iterator.get(integrationName) + "Proxy");
            Class[] classNameInterfaces=className.getInterfaces();


            Method[] methodList = className.getMethods();
            StringBuilder stringBuilderIntegrate = new StringBuilder();
            StringBuilder stringBuilderParameter= new StringBuilder();
            StringBuilder stringBuilderProxy = new StringBuilder();
            int i=0;
            for (Method method : methodList) {
                String integrate = new String(integration);
                String parameterList=new String(parameterData);
                String proxy=new String(proxyData);
                integrate = integrate.replaceAll("funtionName", method.getName());



                String mapping=((RequestMapping)classNameInterfaces[0].getMethods()[0].getAnnotations()[2]).method()[0].toString().toLowerCase();
                proxy=proxy.replaceAll("MappingType","@"+mapping.substring(0,1).toUpperCase()+mapping.substring(1)+"Mapping");
                proxy = proxy.replaceAll("APIname",  method.getName());

                if (method.getName().contains(((String) iterator.get(integrationName)).toLowerCase())) {

                    Parameter[] parameters = method.getParameters();
                    int j=0;
                    if (parameters.length != 0) {
                        for(Parameter parameter:parameters){
                            if(j>0){
                                stringBuilderParameter.append(",");
                            }
                            parameterList=parameterList.replaceAll("parameterdata",((RequestParam)parameter.getAnnotations()[2]).value());
                            parameterList=parameterList.replaceAll("parameter",method.getParameterTypes()[0].getName()+" "+((RequestParam) method.getParameters()[0].getAnnotations()[2]).value());
                            stringBuilderParameter.append(parameterList);
                            j++;
                            }
                        integrate = integrate.replaceAll("datatype", parameterList);
                        integrate = integrate.replaceAll("integrationspecific", "return new ResponseEntity<String>(" + ((String) iterator.get(integrationName)).toLowerCase() + "Proxy." + method.getName() +"("+((RequestParam) method.getParameters()[0].getAnnotations()[2]).value()+"), HttpStatus.OK);");

                        proxy=proxy.replaceAll("path","\""+((RequestMapping)classNameInterfaces[0].getMethods()[i].getAnnotations()[2]).value()[0]+"\"");
                        i++;
                        proxy=proxy.replaceAll("parameter","@RequestParam(\""+((RequestParam)method.getParameters()[0].getAnnotations()[2]).value()+"\")"+method.getParameterTypes()[0].getName()+" "+((RequestParam) method.getParameters()[0].getAnnotations()[2]).value());
                    } else {
                        integrate = integrate.replaceAll("datatype", "");
                        integrate = integrate.replaceAll("integrationspecific", "return new ResponseEntity<String>(" + ((String) iterator.get(integrationName)).toLowerCase() + "Proxy." + method.getName() + "(), HttpStatus.OK);");

                        proxy=proxy.replaceAll("path","\""+((RequestMapping)classNameInterfaces[0].getMethods()[i].getAnnotations()[2]).value()[0]+"\"");
                        i++;
                        proxy=proxy.replaceAll("parameter","");
                    }
                    stringBuilderIntegrate.append(integrate);
                    stringBuilderIntegrate.append("\n");


                    stringBuilderProxy.append(proxy);
                    stringBuilderProxy.append("\n");
                } else {
                    break;
                }
            }
            content = content.replaceAll("integrationData", stringBuilderIntegrate.toString());
            fileWriter.write(content);
            fileWriter.close();

            proxyContent = proxyContent.replaceAll("Data", stringBuilderProxy.toString());
            proxyFileWriter.write(proxyContent);
            proxyFileWriter.close();

            File myFoo = new File("/Users/prateekkoul/Documents/spring-server-generated (1) copy/src/main/java/io/swagger/api/"+iterator.get(integrationName)+"ApiController.java");
            FileWriter fooWriter = new FileWriter(myFoo, false);
            fooWriter.write(content);
            fooWriter.close();



            FileWriter integrateFile = new FileWriter(new File("/Users/prateekkoul/Documents/spring-server-generated (1) copy/src/main/java/io/swagger/api/"+iterator.get(integrationName)+"Api.java"), false);
            integrateString=integrateString.replaceAll("Void","String");
            integrateFile.write(integrateString);
            integrateFile.close();


        }
    }
}
