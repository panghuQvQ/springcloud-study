package com.wang.order;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderApplication.java
 * @Description TODO
 * @createTime 2022年12月28日 14:45:00
 */
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);

        for (String arg : args) {
            System.out.println(arg);
        }
    }






    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        RestTemplate restTemplate = builder.build();
        return restTemplate;
    }

//    @Bean
//    public CommandLineRunner commandLineRunner() {
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
//                for (String arg : args) {
//                    System.out.println(arg);
//                }
//            }
//        };
//    }
//
//    @Bean
//    public ApplicationRunner applicationRunner(){
//        return new ApplicationRunner() {
//            @Override
//            public void run(ApplicationArguments args) throws Exception {
//                System.out.println(args.getNonOptionArgs()); // 没有加横线的 Program arguments
//                System.out.println(args.getOptionNames()); // 加了横线的 Program arguments的 key值
//                System.out.println(args.getOptionValues("k1"));
//
//                for (String sourceArg : args.getSourceArgs()) { // 获取原生的参数字符串
//                    System.out.println(sourceArg);
//                }
//            }
//        };
//    }
}
