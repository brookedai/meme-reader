package com.memes.memereader;

import Reader.ParserString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class ParserTest {

    @Test
    public void test() {
        ParserString p = new ParserString();

        String link1 = "[locale: \"la\" description: \"i wan fuit gummy\\nFUIT GUMMY FUIT GUMMY\\n\" bounding_poly " +
                "{ vertices { x: 57 y: 38 } vertices { x: 687 y: 38 } vertices { x: 687 y: 764 } vertices { x: 57 y: 764 } } , description: \"i\" bounding_poly { vertices { x: 161 y: 38 } vertices { x: 176 y: 38 } vertices { x: 176 y: 92 } vertices { x: 161 y: 92 } } , description: \"wan\" bounding_poly { vertices { x: 181 y: 38 } vertices { x: 265 y: 38 } vertices { x: 265 y: 92 } vertices { x: 181 y: 92 } } , description: \"fuit\" bounding_poly { vertices { x: 296 y: 38 } vertices { x: 356 y: 38 } vertices { x: 356 y: 92 } vertices { x: 296 y: 92 } } , description: \"gummy\" bounding_poly { vertices { x: 374 y: 38 } vertices { x: 525 y: 38 } vertices { x: 525 y: 92 } vertices { x: 374 y: 92 } } , description: \"FUIT\" bounding_poly { vertices { x: 58 y: 683 } vertices { x: 160 y: 684 } vertices { x: 159 y: 757 } vertices { x: 57 y: 756 } } , description: \"GUMMY\" bounding_poly { vertices { x: 169 y: 685 } vertices { x: 366 y: 687 } vertices { x: 365 y: 759 } vertices { x: 168 y: 757 } } , description: \"FUIT\" bounding_poly { vertices { x: 380 y: 687 } vertices { x: 481 y: 688 } vertices { x: 480 y: 761 } vertices { x: 379 y: 760 } } , description: \"GUMMY\" bounding_poly { vertices { x: 493 y: 689 } vertices { x: 687 y: 691 } vertices { x: 686 y: 764 } vertices { x: 492 y: 762 } } ]";

        String result1 = p.getString(link1);
        String expected1 = "i wan fuit gummy FUIT GUMMY FUIT GUMMY";

        assertEquals(result1, expected1);

        String link2 = "[locale: \"en\" description: \"THAT MOMENT WHEN YOU FIND\\nTHE PERFECT AVOCADO AT THE\\nSUPERMARKET\\n\" bounding_poly { vertices { x: 34 y: 13 } vertices { x: 696 y: 13 } vertices { x: 696 y: 620 } vertices { x: 34 y: 620 } } , description: \"THAT\" bounding_poly { vertices { x: 34 y: 13 } vertices { x: 138 y: 13 } vertices { x: 138 y: 87 } vertices { x: 34 y: 87 } } , description: \"MOMENT\" bounding_poly { vertices { x: 148 y: 13 } vertices { x: 343 y: 13 } vertices { x: 343 y: 87 } vertices { x: 148 y: 87 } } , description: \"WHEN\" bounding_poly { vertices { x: 340 y: 13 } vertices { x: 472 y: 13 } vertices { x: 472 y: 87 } vertices { x: 340 y: 87 } } , description: \"YOU\" bounding_poly { vertices { x: 488 y: 13 } vertices { x: 562 y: 13 } vertices { x: 562 y: 87 } vertices { x: 488 y: 87 } } , description: \"FIND\" bounding_poly { vertices { x: 589 y: 13 } vertices { x: 678 y: 13 } vertices { x: 678 y: 87 } vertices { x: 589 y: 87 } } , description: \"THE\" bounding_poly { vertices { x: 36 y: 476 } vertices { x: 109 y: 476 } vertices { x: 109 y: 548 } vertices { x: 36 y: 548 } } , description: \"PERFECT\" bounding_poly { vertices { x: 121 y: 476 } vertices { x: 306 y: 476 } vertices { x: 306 y: 548 } vertices { x: 121 y: 548 } } , description: \"AVOCADO\" bounding_poly { vertices { x: 318 y: 476 } vertices { x: 525 y: 476 } vertices { x: 525 y: 548 } vertices { x: 318 y: 548 } } , description: \"AT\" bounding_poly { vertices { x: 544 y: 476 } vertices { x: 598 y: 476 } vertices { x: 598 y: 548 } vertices { x: 544 y: 548 } } , description: \"THE\" bounding_poly { vertices { x: 613 y: 476 } vertices { x: 696 y: 476 } vertices { x: 696 y: 548 } vertices { x: 613 y: 548 } } , description: \"SUPERMARKET\" bounding_poly { vertices { x: 206 y: 544 } vertices { x: 536 y: 544 } vertices { x: 536 y: 620 } vertices { x: 206 y: 620 } } ]";
        String result2 = p.getString(link2);
        String expected2 = "THAT MOMENT WHEN YOU FIND THE PERFECT AVOCADO AT THE SUPERMARKET";

        assertEquals(result2, expected2);

    }
}
