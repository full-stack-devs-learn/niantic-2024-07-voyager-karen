package com.niantic;

public class Main
{
    public static void main(String[] args)
    {
        examples();
        section01();
        section02();
        section03();
        clairesCookies();
        elliotsYardCare();
    }

    public static void examples()
    {
        // i. Create a variable that stores the name of the best
        // programming language.
        String bestLanguage;
        bestLanguage = "Java";

        System.out.println("i) Best Programming Language");
        System.out.println("language: " + bestLanguage);
        System.out.println();



        // ii. Create a variable to store the speed limit in
        // a school zone.
        int speedLimit;
        speedLimit = 20;

        System.out.println("ii) Speed Limit");
        System.out.println("speedLimit: " + speedLimit);
        System.out.println();
    }

    public static void section01()
    {
        /******************** Section 1 ********************/
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("Section 1: Declaring Variables");
        System.out.println("**********************************************");
        System.out.println();
        System.out.println();



        // 1. Declare a new variable to hold your name.
        // Variable name: name
        // Data Type: string (names/words are strings)

        String name;
        name = "Karen";
        System.out.println("Name: " + name);


        // 2. Declare a variable to hold your age.
        // Variable name: age
        // Data Type: int (age is a whole number)

        int age;
        age = 28;
        System.out.println("Age: " + age);


        // 3. Declare a variable that holds the first 5 digits of PI.
        // Variable name: pi
        // Data Type: double (pi is a number with decimal places)

        double pi;
        pi = 3.1415;
        System.out.println("First 5 digits of PI: " + pi);

        // 4. Declare a variable holds the price of
        // an adult meal at the buffet.
        // Variable name: price
        // Data Type: double (price contains a dollar and cent value)

        double price;
        price = 0;
        System.out.println("Adult Meal Price: " + price);

        // NOTE: the decimal data type  is not automatically recognized
        // see lecture notes
    }

    public static void section02()
    {

        /******************** Section 2 ********************/
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("Section 2: Selecting DataTypes");
        System.out.println("**********************************************");
        System.out.println();
        System.out.println();

        // From this point forward you will need to choose
        // the variable name for each of your variables
        // as well as the DataType that will be used for
        // each variable.



        // 5. Declare a variable to store the name of your
        // favorite super hero.

        String fave_super_hero;
        fave_super_hero = "Spider-Man";
        System.out.println("Favorite Superhero: " + fave_super_hero);

        // Hint: You cannot use the same variable name
        // as a variable that you have used before.



        // 6. Declare a variable to hold the value of
        // value of a test score. The test has 100
        // questions and each question is worth 1 point.
        // (You can choose the score)

        int test_score;
        test_score = 98;
        System.out.print("Test Score: " + test_score);

        // 7. Declare a variable that holds the current
        // population in the United States.
        // (search what the population is today)

        double current_us_population;
        current_us_population = 333.3;
        System.out.println("Current U.S Population " + current_us_population);

        // 8. Declare a variable that holds the current
        // population in China.
        // (search what the population is today)

        double current_china_population;
        current_china_population = 1.412;
        System.out.println("Current China Population: " + current_china_population);


        // 9. Declare a variable that holds the current
        // population in the world.
        // (search what the population is today)

        double current_world_population;
        current_world_population = 7.951;
        System.out.println("Current World Population: " + current_world_population);


        // 10. Declare a variable that specifies whether
        // or not your mouse is wireless.

        boolean is_mouse_wireless;
        is_mouse_wireless = true;
        System.out.println("Wireless Mouse? " + is_mouse_wireless);

        // 11. Search what the Latitude and Longitude of your
        // home town are. Then declare 2 variables
        // to store the Latitude and Longitude.

        double sanjose_latitude;
        double sanjose_longitude;
        sanjose_latitude = 37.3387;
        sanjose_longitude = 121.8853;
        System.out.println("San Jose Latitude and Longitude: " + sanjose_latitude + ", " + sanjose_longitude);


        // 12. Create a variable that holds the current
        // Microsoft stock price.

        double microsoft_stock_price;
        microsoft_stock_price = 444.85;
        System.out.println("Microsoft Stock Price: " + microsoft_stock_price);


    }
    
    public static void section03()
    {
        /******************** Section 3 ********************/
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("Section 3: Expressions and Arithmetic");
        System.out.println("**********************************************");
        System.out.println();
        System.out.println();

        /*
         * In this section you are expected to create
         * multiple variables in each exercise. You should
         * create as many variables as you need in order to
         * solve each problem.
         *
         * Make sure that your variable names are meaningful
         * and that the name describes the purpose of the
         * variable. Also, your code should not have any
         * "magic numbers" but anyone who reads the code
         * should be able to understand your code and
         * the calculations.
         */

        System.out.println("----------------------------");
        System.out.println("Backyard Basketball");
        System.out.println("-----------------------------");
        System.out.println();


        // 13. In his last basketball game Pete made 7 shots,
        // but missed 3 of his shots.

        int shots_pete_made;
        int shots_pete_missed;
        shots_pete_made = 7;
        shots_pete_missed = 3;

        // How many shots did Pete take?

        int shots_pete_took;
        shots_pete_took = shots_pete_made + shots_pete_missed;
        System.out.println("Pete took " + shots_pete_took + " shots.");



        // 14. In his previous basketball game Pete took 20 shots.
        // He missed 6 shots, and he made 3 three point shots.

        int shots_took_by_pete;
        int shots_missed_by_pete;
        int three_point_shots_by_pete;
        shots_took_by_pete = 20;
        shots_missed_by_pete = 6;
        three_point_shots_by_pete = 3 * 3;

        // How many 2 point shots did Pete make?\
        int two_points_shots_by_pete;
        two_points_shots_by_pete = (shots_took_by_pete - shots_missed_by_pete) / 2;
        System.out.println("Pete made " + two_points_shots_by_pete+ " two point shots");



        // 15. Pete and Pat are teammates. Pete made 6 shots.
        // Pat made twice as many shots as Pete.

        int shots_taken_by_pete;
        int shots_pat_made;
        shots_taken_by_pete = 6;
        shots_pat_made = shots_taken_by_pete * 2;

        // How many total shots did they make?
        int total_shots;
        total_shots = shots_taken_by_pete + shots_pat_made;
        System.out.println("Total shots made by Pete and Pat: " + total_shots);


        // 16. Pete has made 13 shots, Pat has made 9.
        // If both Pete and Pat make 1 more shot each
        // before the game ends, how many total shots
        // did the Terrifying Twosome make in the game?

        int shots_made_from_pete;
        int shots_made_by_pat;
        shots_made_from_pete = 13 + 1;
        shots_made_by_pat = 9 + 1;

        int twosome_total_shots = shots_made_from_pete + shots_made_by_pat;
        System.out.println("The Terrifying Twosome made " + twosome_total_shots + " total shots in the game.");


        // 17. In his last game Pete made 11 shots.
        // he missed 4 shots.

        int last_game_shots_made_by_pete;
        int last_game_missed_made_by_pete;
        last_game_shots_made_by_pete = 11;
        last_game_missed_made_by_pete = 4;

        // What percentage of his shots did he make?
        float total_shots_taken_pete;
        total_shots_taken_pete = last_game_shots_made_by_pete + last_game_missed_made_by_pete;
        double percentage_of_shots_by_pete = (double) (last_game_shots_made_by_pete / total_shots_taken_pete) * 100;
        System.out.println("Percent of shots Pete made: " + (int) percentage_of_shots_by_pete + "%");


        // 18. Pete and Pat have decided to only take 3 point
        // shots in their next game. Together they make 70%
        // of their 3 point shots.

        double percent_of_three_points_made;
        percent_of_three_points_made = 0.7;

        // The team that they are playing scores 31 points a game.

        int team_score;
        team_score = 31;

        // How many shots do Pete and Pat have to take to win
        // this game?

        float target_score;
        target_score = (float) (team_score + 1) / 3;
        int shots_needed_to_win = (int) (target_score / percent_of_three_points_made);
        System.out.println("Pete and Pat need to make "+ shots_needed_to_win +" shots to win this game.");





    }
    
    public static void clairesCookies()
    {

        System.out.println();
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("Claire's Cookies");
        System.out.println("-----------------------------");
        System.out.println();



        // 19. Claire sells cookies by the dozen. Sean has 14 students
        // in his class. He has bought 3 dozen cookies for his class.

        // Sean wants to divide the cookies evenly between
        // his students. How many cookies will each student
        // receive? (Students can only receive whole cookies)



        // 20. Sean has 14 students in his class.
        // He has bought 3 dozen cookies for his class.

        // Sean wants to divide the cookies evenly between
        // his students. After giving the students their
        // cookies, how many cookies will be left over?



        // 21. Sean's class has earned a cookie party.

        // If Sean has 14 students, how many dozen cookies
        // does he need to buy from Claire's Cookies so that
        // each student can receive 3 cookies.



        // 22. Sean's class has earned a cookie party. The number
        // of cookies that a student receives depends on
        // the score that they received on the cookie test.
        // Sean has 14 students.

        // 100 = 4 cookies
        // 90+ = 3 cookies
        // everyone else 2 cookies

        // Sean has 14 students. Chuck and Andrea scored
        // a perfect 100 on the test. Regina, Glen, Tony and Lorrie
        // all scored above 90. The rest of the class scored
        // below 90.

        // How many dozen cookies does Sean need to buy.



        // 23. If Claire's Cookies sells each dozen cookies for 12.99,
        // how much will it cost Sean to buy 4 dozen cookies.



        // (Use this information for the next several questions)
        // Claire now charges different prices for different
        // types of cookies as follows:

        // Snicker Doodles = $12.99 / dz
        // Chocolate Chip = $13.99 / dz
        // Frosted Chocolate Chip = $15.99 / dz

        // Each dozen cookies must be the same type of cookie.

        // Sean has allowed his students to choose 3
        // cookies each. Here is what they have selected

        // Snicker Doodles | Chocolate Chip | Frosted Chocolate Chip
        // ---------------------------------------------------------
        // 9                 15               18

        // 24. How many total dozen cookies does Sean need to buy?



        // 25. What is the total cost of this order?



        // 26. How many cookies will be left over of each type of cookie?
        // (Snicker Doodles, Chocolate Chip, Frosted Chocolate Chip)



        // 27. How much money could Sean have saved if he would
        // have bought: 2 dz Frosted Chocolate Chip
        //              1 dz Chocolate Chip
        //              1 dz Snicker Doodle
    }


    // bonus - challenge
    public static void elliotsYardCare()
    {

        System.out.println();
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("Elliot's Yard Care");
        System.out.println("----------------------------");
        System.out.println();

        // Use the following information to answer the remaining questions.

        // Elliot runs a yard care business named "Elliot's Yard Care".
        // He charges $30 to mow and trim a medium size lawn (100 ft x 50 ft).
        // Elliot takes pride in his work and his lawns look
        // immaculate. In order to maintain such a quality reputation
        // his services include grass clipping removal and
        // complete sweeping of the property after the lawn
        // is mowed.

        // Elliot's goal is to earn at least $10 per hour.
        // It costs him about $2.50 in materials and gas per 1000 sq ft.
        // On average elliot has calculated that it takes him roughly
        // 45 minutes to fully maintain 1000 sq ft.


        // 28. What is the total cost to Elliot when
        // he mows a yard that is 100 x 50 feet?



        // 29. How much total money does Elliot earn
        // to maintain a 100 x 50 ft yard?



        // 30. How much time does it take Elliot to mow
        // a 100 x 50 ft yard?



        // 31. How much money does Elliot earn per hour
        // on a 100 x 50 foot yard?



        // 32. What is Elliot's cost per hour on a medium
        // sized yard?



        // 33. How much money should Elliot charge for a medium yard
        // in order to earn $10 per hour?


    }
}