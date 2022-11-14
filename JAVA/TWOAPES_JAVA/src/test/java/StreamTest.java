import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
public class StreamTest {

    @Test
    public void test(){
        List<String> list=Arrays.asList("a","b","c");
        Stream<String> stream=list.stream();
        log.info("order stream:{}", stream);

        Stream<String> parallelStream=list.parallelStream();
        log.info("parallel stream:{}", parallelStream);

        String[] array = {"a","b","c"};
        Stream<String> arrayStream=Arrays.stream(array);
        log.info("array stream:{}", arrayStream);

        Stream<Integer> streamOf = Stream.of(1,2,3,4,5,6,7,8);
        log.info("of stream:{}",streamOf);
 
        Stream<Integer> iterateStream = Stream.iterate(0, (x) -> x + 1).limit(3);
        log.info("iterate stream:{}",iterateStream);
 
        Stream<Double> generateStream = Stream.generate(Math::random).limit(3);
        log.info("generate stream:{}",generateStream);
    }
}
