package Reader;

public class ParserString {

    public String getString(String memeDescription) {
        String message = "";
        if (memeDescription.contains("description:") && memeDescription.contains(" bounding_poly")) {
            int startIndex = memeDescription.indexOf("description: ");
            int endIndex = memeDescription.indexOf(" bounding_poly", startIndex);
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
            message = message.substring(0, message.length()-1);
        }

        return message; //stud
    }
}
