    class Person {
        String firstName;
        String lastName;
        int birthYear;
        int birthMonth;
        int birthDate;
        String phoneNumber;
        Person[] friendArray;
         
        Person(String firstN, String lastN, int year, int month, int date, String phone) {
            this.firstName   = firstN;
            this.lastName    = lastN;
            this.birthYear   = year;
            this.birthMonth  = month;
            this.birthDate   = date;
            this.phoneNumber = phone;
        }
    }
         
    class ex6_2 {
        public static void main(String args[]) {
            /* for protection of personal data, pseudo values are used */
         
            Person person1 = new Person("Taro", "Tokyo"  , 1985,  9, 20, "080-1234-5678");
            Person person2 = new Person("Jiro", "Osaka"  , 1981,  6, 18, "090-8765-4321");
            Person person3 = new Person("Saburo", "Aichi", 1981, 12, 23, "090-3333-5555");
            Person person4 = new Person("Shiro", "Gifu"  , 1974,  2,  3, "090-2222-1111");
         
            Person[] person1FriendArray = new Person[2]; // Friends are Jiro and Saburo
            Person[] person2FriendArray = new Person[3]; // Friends are Taro, Saburo and Shiro
            Person[] person3FriendArray = new Person[1]; // Friend is Shiro
            Person[] person4FriendArray = new Person[2]; // Friend are Jiro and Saburo
         
            person1FriendArray[0] = person2;
            person1FriendArray[1] = person3;
         
            person2FriendArray[0] = person1;
            person2FriendArray[1] = person3;
            person2FriendArray[2] = person4;
         
            person3FriendArray[0] = person4;
         
            person4FriendArray[0] = person2;
            person4FriendArray[1] = person3;
     
            person1.friendArray = person1FriendArray;
            person2.friendArray = person2FriendArray;
            person3.friendArray = person3FriendArray;
            person4.friendArray = person4FriendArray;
     
            /* print the input data */
            printPersonalInfo(person1);
            printPersonalInfo(person2);
            printPersonalInfo(person3);
            printPersonalInfo(person4);
        }
         
        static void printPersonalInfo(Person p) {
            int i;
            System.out.print("NAME: " + p.lastName + " " + p.firstName + "\n");
            System.out.print("Date of Birth: " + p.birthYear
                             + " " + p.birthMonth
                             + " " + p.birthDate + "\n");
            System.out.print("  Number of friends = " + p.friendArray.length + "\n");
            for( i = 0; i < p.friendArray.length; i++ ) {
                System.out.print("    Name of friend " + i
                                 + ": " + p.friendArray[i].lastName 
                                 + " " + p.friendArray[i].firstName + "\n");
                System.out.print("    Date of Birth: " + p.friendArray[i].birthYear
                                 + " " + p.friendArray[i].birthMonth
                                 + " " + p.friendArray[i].birthDate + "\n");
            }
        }
    }
