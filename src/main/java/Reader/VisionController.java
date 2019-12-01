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
    ParserString p = new ParserString();

    @Autowired
    private ResourceLoader resourceLoader;

    // [START spring_vision_autowire]
    @Autowired
    private CloudVisionTemplate cloudVisionTemplate;
    // [END spring_vision_autowire]

    @RequestMapping("/")
    public String getTextDetection(@RequestParam(value="url") String url) {
        Resource imageResource = this.resourceLoader.getResource("url:" + url);
        AnnotateImageResponse textResponse = this.cloudVisionTemplate.analyzeImage(
                imageResource, Feature.Type.TEXT_DETECTION);
        AnnotateImageResponse descResponse = this.cloudVisionTemplate.analyzeImage(
                imageResource, Feature.Type.LABEL_DETECTION);

        String stringTextResponse = textResponse.getTextAnnotationsList().toString();
        String stringDescResponse = descResponse.getLabelAnnotationsList().toString();

        return "{\"desc\":\""+p.getString(stringTextResponse )+"\"}";
    }
}