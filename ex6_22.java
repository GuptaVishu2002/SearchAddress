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
     
        public String toString(){
            int i;
            String str;
            str = "NAME: " + this.lastName + " " + this.firstName + "\n"
                +"Date of Birth: "
                + this.birthYear + " " + this.birthMonth + " " + this.birthDate + "\n"
                + "  Number of friends = " + this.friendArray.length + "\n";
            
            for( i = 0; i < this.friendArray.length; i++ ) {
                str = str + "    Name of friend " + i
                    + ": " + this.friendArray[i].lastName 
                    + " " + this.friendArray[i].firstName + "\n"
                    + "    Date of Birth: " + this.friendArray[i].birthYear
                    + " " + this.friendArray[i].birthMonth
                    + " " + this.friendArray[i].birthDate +"\n";
            }
            return str;
        }
    }
         
    class ex6_22 {
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
            System.out.print(person1);
            System.out.print(person2);
            System.out.print(person3);
            System.out.print(person4);
        }
    }
