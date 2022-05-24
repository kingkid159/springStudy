package basic_6.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Dbconfig {

	//close는 커넥션 풀에 보관된 Connection을 닫는다.
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		// DataSource 객체 생성
		DataSource ds = new DataSource();
		// JDBC 드라이버 클래스를 지정, 여기선 mysql
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		//JDBC URL 지정 테이블 캐릭터셋을 utf8로 설정했으니 characterEncoding도 같게 설정 -없음 주의
		ds.setUrl("jdbc:mysql://localhost/spring5fs?characterEncoding=utf8");
		//db 연결할 계정과 비밀번호 지정
		ds.setUsername("spring5");
		ds.setPassword("spring5");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		return ds;
	}
}
