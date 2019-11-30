package Reader;

import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.vision.CloudVisionTemplate;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisionController {

    @Autowired
    private ResourceLoader resourceLoader;

    // [START spring_vision_autowire]
    @Autowired
    private CloudVisionTemplate cloudVisionTemplate;
    // [END spring_vision_autowire]

    @RequestMapping("/getTextDetection")
    public String getTextDetection(@RequestParam(value="url") String url) {
        Resource imageResource = this.resourceLoader.getResource("url:" + url);
        AnnotateImageResponse response = this.cloudVisionTemplate.analyzeImage(
                imageResource, Feature.Type.DOCUMENT_TEXT_DETECTION);
        return response.getTextAnnotationsList().toString();
    }
}