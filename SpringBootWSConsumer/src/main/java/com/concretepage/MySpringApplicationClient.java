package com.concretepage;
import java.util.logging.Logger;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.concretepage.wsdl.AddArticleResponse;
import com.concretepage.wsdl.ArticleInfo;
import com.concretepage.wsdl.DeleteArticleResponse;
import com.concretepage.wsdl.GetAllArticlesResponse;
import com.concretepage.wsdl.GetArticleByIdResponse;
import com.concretepage.wsdl.ServiceStatus;
import com.concretepage.wsdl.UpdateArticleResponse;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class MySpringApplicationClient implements ApplicationRunner {  
	
	public static void main(String[] args) {
		SpringApplication.run(MySpringApplicationClient.class, args);
    }       
	
//	@Bean
//	CommandLineRunner lookup(ArticleClient articleClient) {
//		return args -> {
//			System.out.println("--- Get Article by Id ---");
//			GetArticleByIdResponse articleByIdResponse = articleClient.getArticleById(1);
//			ArticleInfo articleInfo = articleByIdResponse.getArticleInfo();
//			System.out.println(articleInfo.getArticleId() + ", "+ articleInfo.getTitle()
//			     + ", " + articleInfo.getCategory());
//			
//			System.out.println("--- Get all Articles ---");
//			GetAllArticlesResponse allArticlesResponse = articleClient.getAllArticles();
//			allArticlesResponse.getArticleInfo().stream()
//			   .forEach(e -> System.out.println(e.getArticleId() + ", "+ e.getTitle() + ", " + e.getCategory()));
//			
//			System.out.println("--- Add Article ---");
//		    String title = "Spring REST Security using Hibernate";
//		    String category = "Spring";
//			AddArticleResponse addArticleResponse = articleClient.addArticle(title, category);
//			articleInfo = addArticleResponse.getArticleInfo();
//			if (articleInfo != null) {
//			  System.out.println(articleInfo.getArticleId() + ", "+ articleInfo.getTitle()
//			       + ", " + articleInfo.getCategory());
//			}
//			ServiceStatus serviceStatus = addArticleResponse.getServiceStatus();
//			System.out.println("StatusCode: " + serviceStatus.getStatusCode() + 
//					", Message: " + serviceStatus.getMessage());
//			
//			System.out.println("--- Update Article ---");
//			articleInfo = new ArticleInfo();
//			articleInfo.setArticleId(1);
//			articleInfo.setTitle("Update:Java Concurrency");
//			articleInfo.setCategory("Java");
//			UpdateArticleResponse updateArticleResponse = articleClient.updateArticle(articleInfo);
//			serviceStatus = updateArticleResponse.getServiceStatus();
//			System.out.println("StatusCode: " + serviceStatus.getStatusCode() + 
//					", Message: " + serviceStatus.getMessage());
//			System.out.println("--- Delete Article ---");
//			long articleId = 3;
//			DeleteArticleResponse deleteArticleResponse = articleClient.deleteArticle(articleId);
//			serviceStatus = deleteArticleResponse.getServiceStatus();
//			System.out.println("StatusCode: " + serviceStatus.getStatusCode() + 
//					", Message: " + serviceStatus.getMessage());			
//		};
//	}	
	
    //private static final Logger logger = LoggerFactory.getLogger(MySpringApplicationClient.class);

		@Override
	   public void run(ApplicationArguments arg0) throws Exception {
			System.out.println("hello world");
			System.out.println("--- Get Article by Id ---");
			ArticleClient articleClient = new ArticleClient();
			try {
				GetArticleByIdResponse articleByIdResponse = articleClient.getArticleById(1);
				ArticleInfo articleInfo = articleByIdResponse.getArticleInfo();
				System.out.println(articleInfo.getArticleId() + ", "+ articleInfo.getTitle()
				     + ", " + articleInfo.getCategory());	
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("error on the client.!!!!!");
			}
			
		}
    
}            