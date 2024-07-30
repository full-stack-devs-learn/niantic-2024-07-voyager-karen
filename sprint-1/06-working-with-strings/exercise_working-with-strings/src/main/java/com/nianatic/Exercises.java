package com.nianatic;


public class Exercises
{
    /*
     * In this function you need to convert a word
     * either to all upper case letters or all
     * lower case.
     *
     * The user will provide you with the word, and
     * which case you should change it to.
     *
     * changeCase("Fancy", false) => fancy
     * changeCase("chocolate", true) => CHOCOLATE
     * changeCase("PARTY", false) => party
     * changeCase("PARTY", true) => PARTY
     *
     */
    public String changeCase(String word, boolean toUpperCase)
    {
        String newWord;
        if (toUpperCase) {
            newWord = word.toUpperCase();

        } else {
            newWord = word.toLowerCase();
        }

        return newWord;
    }

    /*
     * As a full stack developer you will often need to
     * dynamically create Html in code. In this function
     * you are required to take the input and convert it
     * to a valid Html String.
     *
     * Html is made up of elements (also known as tags)
     * such as:
     *
     * <p>your content here</p>
     *
     * The element is <p> for paragraph
     *
     * Most elements have both an opening <p>
     * and a closing </p> tag, and the content
     * goes inside.
     *
     * The user will provide you with the content, and
     * the name of Html element.
     *
     * You need to return the formatted Html
     *
     * createHtml("This is a paragraph", "p") => <p>This is a paragraph</p>
     * createHtml("Bold text", "strong") => <strong>Bold text</strong>
     *
     */
    public String createHtml(String content, String elementName)
    {
        String newSentence = "";
        if (elementName.equals("p"))
        {
            newSentence = "<p>" + content + "</p>";
        }
        if (elementName.equals("strong"))
        {
            newSentence = "<strong>" + content + "</strong>";
        }
        if (elementName.equals("quote"))
        {
            newSentence = "<quote>" + content + "</quote>";
        }
        if (elementName.equals("em"))
        {
            newSentence = "<em>" + content + "</em>";
        }
        return newSentence;
    }

    /*
     * Sometimes Html elements do not have any content
     *
     * <p></p>
     *
     * Elements that have no content can be "self closing".
     *
     * <p />
     *
     * Modify the logic that you used for the CreateHtml
     * to return a self closing element when there is no
     * content provided.
     *
     * moreHtml("This is a paragraph", "p") => <p>This is a paragraph</p>
     * moreHtml("", "p") => <p />
     *
     */
    public String moreHtml(String content, String elementName)
    {
        String newSentence = "";

        switch (elementName) {
            case "p":
                if (content.isEmpty()) {
                    newSentence = "<p />";
                } else {
                    newSentence = "<p>" + content + "</p>";
                }
                break;
            case "strong":
                if (content.isEmpty()) {
                    newSentence = "<strong>" + "Text" + "</strong>";
                } else {
                    newSentence = "<strong>" + content + "</strong>";
                }
                break;
            case "quote":
                if (content.isEmpty()) {
                    newSentence = "<quote />";
                } else {
                    newSentence = "<quote>" + content + "</quote>";
                }

        }

        return newSentence;
    }

    /*
     * Xml is similar to Html - it uses element names
     * to describe the data that is being stored.
     *
     * Unlike html, however, there are no pre-defined
     * element names in xml. In other words, you can use
     * any word as a tag name.
     *
     * <customer><id>1</id><name>Belinda Carter</name></customer>
     *
     * The user has a list of customer id and names. They
     * will provide you each customer id and their name.
     * You are required to return a formatted xml String
     * like the pattern shown above.
     *
     * createXml(1, "Belinda Carter") => <customer><id>1</id><name>Belinda Carter</name></customer>
     *
     */
    public String createXml(int id, String name)
    {
        return  "<customer>" + "<id>" + id + "</id>" + "<name>" + name + "</name>" + "</customer>";
    }

    /*
     * The customer has noted that even though
     * the xml that is returned is correct, it is still
     * somewhat difficult to read because it is all on
     * a single line
     *
     * <customer><id>1</id><name>Belinda Carter</name></customer>
     *
     * Xml can be made easier to read by adding line breaks
     * and indentation like this:
     * (note: indentations are 2 spaces)
     *
     * <customer>
     *   <id>1</id>
     *   <name>Belinda Carter</name>
     * </customer>
     *
     * Modify your logic to return formatted xml.
     * each element must be on its own line.
     * Indent the nested elements with 2 spaces
     *
     * String format codes (see https://www.w3schools.com/java/java_Strings_specchars.asp):
     * \n = new line
     * \t = tab
     * \\ = \
     *
     * formattedXml(1, "Belinda Carter") => <customer>
     *                                        <id>1</id>
     *                                        <name>Belinda Carter</name>
     *                                      </customer>
     *
     */
    public String formattedXml(int id, String name)
    {

        return  "<customer>\n" + "  "+ "<id>" + id + "</id>" + "\n  " + "<name>" + name + "</name>" + "\n</customer>";

    }

    /*
     * In this function you will be given all the
     * individual parts of a full name. You need to
     * return the fully formatted name as a single String
     *
     * The first and last names will always have a value,
     * but a user is not required to have a middle name
     * or a suffix.
     *
     * If middle name or suffix is provided, you must
     * format the name accordingly.
     *
     * Examples:
     * formatFullName("Glen", "", "Williamson", "") => Glen Williamson
     * formatFullName("Glen", "Carter", "Williamson", "") => Glen Carter Williamson
     * formatFullName("Glen", "", "Williamson", "Jr") => Glen Williamson, Jr
     * formatFullName("Glen", "Carter", "Williamson", "Jr") => Glen Carter Williamson, Jr
     *
     */
    public String formatFullName(String firstName, String middleName, String lastName, String suffix)
    {
        String newName = "";
        if (!middleName.isEmpty())
        {
            newName = firstName + " " +  middleName + " " + lastName;
        }
        if (!suffix.isEmpty())
        {
        newName = firstName + " " + middleName + " " + lastName + ", " + suffix;
        }   if (!suffix.isEmpty() && middleName.isEmpty()) {
            newName = firstName + " " + lastName + ", " + suffix;
    }
        if (middleName.isEmpty() && suffix.isEmpty())
        {
            newName = firstName + " " + lastName;
        }
        return newName;
    }

    /*
     * You are writing a program for HR.
     * When they hire a new employee they must be
     * given an username to access the network.
     *
     * The username must always be lower case and
     * is formatted as the employees first name
     * and last name separated by a period.
     *
     * Glen Williamson => glen.willimason
     *
     * If the employee has a middle name, the
     * middle initial should also be added like
     * this
     *
     * Glen Carter Williamson => glen.c.williamson
     *
     * Your function accepts the full name of the employee
     * and you must return the new username.
     *
     * Examples:
     * createUserName("Glen Williamson") => glen.williamson
     * createUserName("Glen Carter Williamson") => glen.c.williamson
     * createUserName("Glen Williamson, III") => glen.williamson
     *
     */
    public String createUserName(String fullName)
    {
        String userName = "";

        // input name: Glen Williamson, III => ["glen williamson", "iii"]
        // the [0] accesses the first element before the "," which is "glen williamson"
        String removeSuffix = fullName.toLowerCase().split(",")[0];

        // strip any white space and use split by space " " to get => ["Glen", "Williamson"]
        String[] nameParts = removeSuffix.strip().split(" ");

        String firstName = nameParts[0];
        String middleInitial = "";
        String lastName = nameParts[nameParts.length - 1];

        String middlePart;

        // converting middle name to initial (Glen Carter Williamson => glen.c.williamson)
        if (nameParts.length == 3)
        {
            middleInitial = nameParts[1].substring(0,1) + ".";
            userName = firstName + "." + middleInitial + lastName;
        }

        // checking if middle name is empty
        if (middleInitial.isEmpty())
        {
            middlePart = ".";
            userName = firstName + middlePart + lastName;
        }



        return userName;
    }
}
