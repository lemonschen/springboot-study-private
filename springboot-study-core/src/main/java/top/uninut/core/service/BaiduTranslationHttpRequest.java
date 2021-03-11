package top.uninut.core.service;

import org.springframework.web.client.RestTemplate;

//@Service
public class BaiduTranslationHttpRequest {

    private RestTemplate restTemplate;

//    @Autowired
    public BaiduTranslationHttpRequest(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public void post(){
        restTemplate.postForEntity("",new Object(),Object.class);
    }
}
