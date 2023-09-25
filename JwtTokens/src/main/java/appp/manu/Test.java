package appp.manu;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Test 
{
	public static void main(String[] args) 
	{
		
		String secret="TestAppOneSample";
		
		String token=Jwts.builder()
				.setId("546789")
				.setSubject("sample")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(2)))
				.setIssuer("Ashok it")
				.signWith(SignatureAlgorithm.HS256, secret.getBytes())
				.compact();
		
		System.out.println(token);
		
		
		Claims c=Jwts.parser().setSigningKey(secret.getBytes())
				.parseClaimsJws(token).getBody();
		
		System.out.println(c.getSubject());
		System.out.print(c.getIssuer());
		System.out.println(c.getExpiration());
		
	}

}
