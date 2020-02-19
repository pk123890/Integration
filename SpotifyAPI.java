import org.springframework.beans.factory.annotation.Autowired;

public class Spotify {
    @Autowired
    Spotifyproxy spotifyProxy;

    String Spotify1(java.lang.String type)
{
return new ResponseEntity<String>(spotifyProxy.spotifyGetFollowingGet(type), HttpStatus.OK);
}
String Spotify2(java.lang.String user_id)
{
return new ResponseEntity<String>(spotifyProxy.spotifyUserDetailsGet(user_id), HttpStatus.OK);
}

}
