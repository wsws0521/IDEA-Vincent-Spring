package cn.vincent.springbootelasticsearch;


import cn.vincent.springbootelasticsearch.service.ItemService;
import cn.vincent.springbootelasticsearch.service.RestHighLevelClientService;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest(classes = EsApplication.class)
@RunWith(SpringRunner.class)
public class EsApplicationTests {

    @Autowired
    private ItemService itemService;
    @Autowired
    private RestHighLevelClientService clientService;

    @Test
    public void contextLoads() {
        String itemsJson = itemService.getItemsJson();
        System.out.println(itemsJson);
    }


    @Test
    public void createIdx() throws IOException {
        String settings = "" +
                "  {\n" +
                "      \"number_of_shards\" : \"2\",\n" +
                "      \"number_of_replicas\" : \"0\"\n" +
                "   }";
        String mappings = "" +
                "{\n" +
                "  \"properties\": {\n" +
                "    \"itemId\": {\n" +
                "      \"type\": \"keyword\",\n" +
                "      \"ignore_above\": 64\n" +
                "    },\n" +
                "    \"urlId\": {\n" +
                "      \"type\": \"keyword\",\n" +
                "      \"ignore_above\": 64\n" +
                "    },\n" +
                "    \"sellAddress\": {\n" +
                "      \"type\": \"text\",\n" +
                "      \"analyzer\": \"ik_max_word\",\n" +
                "      \"search_analyzer\": \"ik_smart\",\n" +
                "      \"fields\": {\n" +
                "        \"keyword\": {\n" +
                "          \"ignore_above\": 256,\n" +
                "          \"type\": \"keyword\"\n" +
                "        }\n" +
                "      }\n" +
                "    },\n" +
                "    \"courierFee\": {\n" +
                "      \"type\": \"text\"\n" +
                "    },\n" +
                "    \"promotions\": {\n" +
                "      \"type\": \"text\",\n" +
                "      \"analyzer\": \"ik_max_word\",\n" +
                "      \"search_analyzer\": \"ik_smart\",\n" +
                "      \"fields\": {\n" +
                "        \"keyword\": {\n" +
                "          \"ignore_above\": 256,\n" +
                "          \"type\": \"keyword\"\n" +
                "        }\n" +
                "      }\n" +
                "    },\n" +
                "    \"originalPrice\": {\n" +
                "      \"type\": \"keyword\",\n" +
                "      \"ignore_above\": 64\n" +
                "    },\n" +
                "    \"startTime\": {\n" +
                "      \"type\": \"date\",\n" +
                "      \"format\": \"yyyy-MM-dd HH:mm:ss\"\n" +
                "    },\n" +
                "    \"endTime\": {\n" +
                "      \"type\": \"date\",\n" +
                "      \"format\": \"yyyy-MM-dd HH:mm:ss\"\n" +
                "    },\n" +
                "    \"title\": {\n" +
                "      \"type\": \"text\",\n" +
                "      \"analyzer\": \"ik_max_word\",\n" +
                "      \"search_analyzer\": \"ik_smart\",\n" +
                "      \"fields\": {\n" +
                "        \"keyword\": {\n" +
                "          \"ignore_above\": 256,\n" +
                "          \"type\": \"keyword\"\n" +
                "        }\n" +
                "      }\n" +
                "    },\n" +
                "    \"serviceGuarantee\": {\n" +
                "      \"type\": \"text\",\n" +
                "      \"analyzer\": \"ik_max_word\",\n" +
                "      \"search_analyzer\": \"ik_smart\",\n" +
                "      \"fields\": {\n" +
                "        \"keyword\": {\n" +
                "          \"ignore_above\": 256,\n" +
                "          \"type\": \"keyword\"\n" +
                "        }\n" +
                "      }\n" +
                "    },\n" +
                "    \"venue\": {\n" +
                "      \"type\": \"text\",\n" +
                "      \"analyzer\": \"ik_max_word\",\n" +
                "      \"search_analyzer\": \"ik_smart\",\n" +
                "      \"fields\": {\n" +
                "        \"keyword\": {\n" +
                "          \"ignore_above\": 256,\n" +
                "          \"type\": \"keyword\"\n" +
                "        }\n" +
                "      }\n" +
                "    },\n" +
                "    \"currentPrice\": {\n" +
                "      \"type\": \"keyword\",\n" +
                "      \"ignore_above\": 64\n" +
                "    }\n" +
                "  }\n" +
                "}";
        clientService.createIndex("idx_item", settings, mappings);
    }


    @Test
    public void importAll() throws IOException {
        clientService.importAll("idx_item", true, itemService.getItemsJson());
    }

    @Test
    public void search() throws IOException {
        SearchResponse search = clientService.search("title", "酒", "currentPrice",
                "11", "149", "sellAddress", "武汉");
        SearchHits hits = search.getHits();
        SearchHit[] hits1 = hits.getHits();
        for (SearchHit documentFields : hits1) {
            System.out.println( documentFields.getSourceAsString());
        }
    }

}
