import org.springframework.beans.factory.annotation.Autowired;

public class Github {
    @Autowired
    Githubproxy githubProxy;

    String Github1(java.lang.String body)
{
return new ResponseEntity<String>(githubProxy.githubCreateRepositoryGet(body), HttpStatus.OK);
}
String Github2()
{
return new ResponseEntity<String>(githubProxy.githubGetRepositoryGet, HttpStatus.OK);
}
String Github3()
{
return new ResponseEntity<String>(githubProxy.githubUserDetailsGet, HttpStatus.OK);
}

}
