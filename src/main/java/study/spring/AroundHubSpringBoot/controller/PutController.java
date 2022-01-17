package study.spring.AroundHubSpringBoot.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import study.spring.AroundHubSpringBoot.dto.MemberDTO;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

	@PutMapping("/default")
	public String putMethod() { return "Hello World!"; }
	
	@PutMapping("/member")
	public String putMember(@RequestBody Map<String, Object> putData) {
		StringBuilder sb = new StringBuilder();
		
		putData.entrySet().forEach(map -> {
			sb.append(map.getKey() + " : " + map.getValue() + "\n");
		});
		
		return sb.toString();
	}
	
	@PutMapping("/member1")
	public String putMemberDto1(@RequestBody MemberDTO memberDTO) { return memberDTO.toString(); }
	
	@PutMapping("/member2")
	public MemberDTO putMemberDto2(@RequestBody MemberDTO memberDTO) { return memberDTO; }
	
	@PutMapping("/member3")
	public ResponseEntity<MemberDTO> putMemberDto3(@RequestBody MemberDTO memberDTO) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDTO);
		// ACCEPTED : 200이 아닌 202로 return이 된다.
	}
}