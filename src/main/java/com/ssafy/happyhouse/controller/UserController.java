package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.User;
import com.ssafy.happyhouse.model.service.JwtServiceImpl;
import com.ssafy.happyhouse.model.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@RequestMapping("/user")
@RestController
@CrossOrigin
public class UserController {
	
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private JwtServiceImpl jwtService;

	@Autowired
	private UserService userService;

	@ApiOperation(value = "로그인", notes = "Access-token과 로그인 결과 메세지를 반환한다.", response = Map.class)
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(
			@RequestBody @ApiParam(value = "로그인 시 필요한 회원정보(아이디, 비밀번호).", required = true) User user) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			User loginUser = userService.login(user);
			if (loginUser != null) {
				String token = jwtService.create("userid", loginUser.getUserid(), "access-token");// key, data, subject
				logger.debug("로그인 토큰정보 : {}", token);
				resultMap.put("access-token", token);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("로그인 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value = "회원인증", notes = "회원 정보를 담은 Token을 반환한다.", response = Map.class)
	@GetMapping("/info/{userid}")
	public ResponseEntity<Map<String, Object>> getInfo(
			@PathVariable("userid") @ApiParam(value = "인증할 회원의 아이디.", required = true) String userid,
			HttpServletRequest request) {
//		logger.debug("userid : {} ", userid);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			try {
//				로그인 사용자 정보.
				User memberDto = userService.userInfo(userid);
				resultMap.put("userInfo", memberDto);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.error("사용 불가능 토큰!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	
	
//	AES256 aes256 = new AES256();
//    UserService userService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//
//    @PostMapping("/regist.do")
//    private String registUser(User user, Model model) {
//        try {
//        	String cipherText = aes256.encrypt(user.getPassword());
//        	user.setPassword(cipherText);
//            userService.registUser(user);
//            return "redirect:/user/login_form.do";
//        } catch (Exception e) {
//            model.addAttribute("errorMsg", "회원가입 중 문제가 발생하였습니다.");
//            return "/user/regist_form.do";
//        }
//    }
//
//    @PostMapping("/login.do")
//    private String login(@RequestParam Map<String, String> map, HttpSession session, Model model) {
//        try {
//        	String text = aes256.encrypt(map.get("password"));
//        	map.put("password", text);
//            String name = userService.login(map);
//            if (name != null) {
//                session.setAttribute("userId", map.get("userid"));
//                session.setAttribute("userName", name);
//                return "redirect:/";
//            } else {
//                model.addAttribute("errorMsg", "아이디나 비밀번호가 일치하지 않습니다.");
//                return "/user/login_form.do";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            model.addAttribute("errorMsg", "로그인 실행 중 문제가 발생하였습니다.");
//            return "/user/login_form.do";
//        }
//    }
//
//    @GetMapping("/logout.do")
//    private String logout(HttpSession session) {
//        session.invalidate();
//        return "redirect:/";
//    }
//
//    @GetMapping("/update_form.do")
//    private String updateForm(HttpSession session, Model model) throws Exception {
//        String userid = (String) session.getAttribute("userId");
//        User user = userService.getUser(userid);
//        user.setPassword(aes256.decrypt(user.getPassword()));
//        model.addAttribute("user", user);
//        return "/user/update";
//    }
//
//    @PostMapping("/update.do")
//    private String update(User user, Model model) {
//        try {
//        	user.setPassword(aes256.encrypt(user.getPassword()));
//            userService.update(user);
//            return "redirect:/";
//        } catch (Exception e) {
//            model.addAttribute("errorMsg", "회원정보 수정 중 문제가 발생하였습니다.");
//            return "/user/update_form.do";
//        }
//    }
//
//    @GetMapping
//    private String search(@RequestParam String userid, @RequestParam String name, Model model) {
//        String password = userService.getPw(userid, name);
//        model.addAttribute("password", password);
//        return "/user/search";
//    }

}
