package soundsystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayerConfig {

  //生成接口对应的实例(CD接口生成一个光盘)
  @Bean
  public CompactDisc compactDisc() {
    return new SgtPeppers();
  }

  //将光盘插入CD播放器
  @Bean
  public CDPlayer cdPlayer(CompactDisc compactDisc) {
    return new CDPlayer(compactDisc);
  }

}
