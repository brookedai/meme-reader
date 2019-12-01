package Reader;

import java.util.ArrayList;

public class ParserString {

    public String getString(String memeDescription) {
        String message = "";
        if (memeDescription.contains("description:") && memeDescription.contains("bounding_poly")) {
            int startIndex = memeDescription.indexOf("description: ");
            int endIndex = memeDescription.indexOf("bounding_poly", startIndex);
            if (endIndex == -1) {
                endIndex = memeDescription.length();
            }
            message = memeDescription.substring(startIndex, endIndex);

            //every link message has -> "description: " ... \n" "
            //but we don't know if there is other quotation marks inside

            //starting index is 0
            int startingIndex = message.indexOf("\"");
            message = message.substring(startingIndex+1, message.length()-1);


            while (message.contains("\\n")) {
                message = message.replace("\\n", " ");
            }
            message = message.substring(0, message.length()-2);
        }

        return message; //stub
    }

    public String getImageDesc(String imageDescription) {
        String message = "";
        ArrayList<String> list = new ArrayList<String>();

        if (imageDescription.contains("description:") && imageDescription.contains("score:") && imageDescription.contains("topicality:")) {
            String messageCut = "";
            message = imageDescription;

            while (message.contains("description:") && message.contains("score:") && message.contains("topicality:")) {
                int startIndex = message.indexOf("description: ");
                messageCut = message.substring(startIndex + 12, message.length());
                message = messageCut;

                int endIndex = messageCut.indexOf("topicality:");
                messageCut = messageCut.substring(0,endIndex);

                message = message.substring(messageCut.length()-1, message.length());
                list.add(messageCut);
            }

            String result = "";

            for (int i = 0; i < list.size() && i < 3; i++) {
                String description = list.get(i);
                int startingIndex = description.indexOf("\"") + 1;
                int endingIndex = description.indexOf("score: ") - 2;
                description = description.substring(startingIndex, endingIndex);

                if (i == list.size()-1 || i == 0) {
                    result = result + description;
                } else result = result + ", " + description;
            }

            message = result;
        }

        return message; //stub
    }

    public String getString_ImageDesc(String memeDescription, String imageDescription) {
        String text = getString(memeDescription);
        String desc = getImageDesc(imageDescription);

        //"{\"desc\":\"People in nature, Sky, Grassland\"}"
        String message = "{\"desc\":\"" + text + "\", " + "\"extended\":\"" + desc + "\"}";
        System.out.println(message);
        return message;
    }

}
