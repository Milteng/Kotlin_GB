package KotlinTasks.Seminar_2;


class Seminar_2 {

    var person:Person = Person("", "", "");

    fun readCommand(input: String): Command?{

        if (input == "show") return ShowCommand(null);

        var t_arr = input.split(" ");

        if (t_arr.size !=4) {
            return null
        } else {
            //не нужно тут нам вводить непонятно что...а то удумали понимаешь....
            if (t_arr[0] != "add") {
                return null;
            }

            //ну по крайней мере ввели 4 строковых литерала
            if (t_arr[2] == "phone") {
                return CommandAddPhone(Person(t_arr[1], t_arr[3], ""));

            }
            else
                if (t_arr[2] == "email") {
                    return CommandAddEmail(Person(t_arr[1], "",t_arr[3]));
                }
                else
                    return null;

        }

    }




    fun run(){
        println("Второй семинар!");


        /*строка подсказка с параметрами*/
        val helpString = "Введите одну из следующих команд команд:\n" +
                "1. exit\n" +
                "2. help\n" +
                "3. show\n" +
                "4. add <Имя> phone <Номер телефона>\n" +
                "5. add <Имя> email <Адрес электронной почты>\n ";

        println(helpString);

        while (true) {
            println("Введите команду");
            val command = readLine() ?: continue;


            when (command){
                "exit" -> break;
                "help" -> println(helpString);
                else -> {
                    val cmd:Command? = readCommand(command);
                    if (cmd == null) {
                        println("Вы ввели неверную команду $command");
                    }
                    else {
                        if (cmd.isValid()) {
                            when (cmd){
                                is CommandAddEmail -> person = cmd.person;
                                is CommandAddPhone -> person = cmd.person;
                                is ShowCommand -> {
                                    if (person.name=="" && person.email=="" && person.phone=="") {
                                        println("Not initialized");
                                        continue;
                                    }
                                    else
                                        if  (person.email == ""){
                                           println("LastCommand: add ${person.name} phone ${person.phone}")}
                                       else {
                                           println("LastCommand: add ${person.name} email ${person.email}")}


                                }
                            }
                        }
                        else println("Команда не валидна!\n" +helpString);

                    }
                }

            }




        }
    }
}