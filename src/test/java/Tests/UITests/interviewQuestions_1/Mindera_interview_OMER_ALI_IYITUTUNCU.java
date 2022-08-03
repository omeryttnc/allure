package Tests.UITests.interviewQuestions_1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Mindera_interview_OMER_ALI_IYITUTUNCU {
    @Test
    public void Mindera_task2() {
        String paragraph = "Hello, my fellow candidate. Hello again.";
        String paragraph2 = "Hello: hello my fellow candidate.";
        System.out.println(findFirstRepeatedWords(paragraph));

    }


    public String findFirstRepeatedWords(String paragraph) {
        List<String> collect = Arrays.stream(paragraph.replaceAll("[^a-zA-Z ]", "")
                .toLowerCase()
                .split(" "))
                .sorted()
                .collect(Collectors.toList());

        Map<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < collect.size() - 1; i++) {
            if (collect.get(i).equals(collect.get(i + 1))) {
                map.put(paragraph.toLowerCase().indexOf(collect.get(i)), collect.get(i));
            }
        }
        paragraph = paragraph.toLowerCase().split("hello")[1];
        String finalParagraph = paragraph;
        if (map.entrySet().stream().anyMatch(t -> t.getKey() < finalParagraph.indexOf("."))) {
            throw new IllegalArgumentException("IllegalArgumentException");
        }

        return (map.entrySet().stream().findFirst().get().getValue());

    }


}
