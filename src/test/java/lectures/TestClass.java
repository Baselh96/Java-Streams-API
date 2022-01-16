package lectures;

import beans.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestClass {
    public static  int[] kasse = new int[] {
            1, // 1cent
            7, // 2cent
            20, // 5cent
            2, // 10cent
            1, // 20cent
            5, // 50cent
            1, // 1 euro
            1, // 2 euro
            1, // 5 euro
            1, // 10 euro
            1, // 20 euro
            1, // 50 euro
            1, // 100 euro
            1, // 200 euro
            2 // 500 euro
    };

    public void run() {
        Kasse newKasse = new Kasse();
        String[] names = {"1 cent", "2 cent", "5 cent", "10 cent", "20 cent", "50 cent", "1 euro", "2 euro", "5 euro", "10 euro", "20 euro", "50 euro", "100 euro", "200 euro", "500 euro"};
        double[] zahlen = {0.01, 0.02, 0.05, 0.10, 0.20, 0.5, 1, 2,5,10,20,50,100,200,500};
        for (int i = 0; i < kasse.length; i++ ) {
            newKasse.addGeld(new Geld( zahlen[i], kasse[i], names[i] , kasse[i] * zahlen[i] ));
        }
        newKasse.print();
        System.out.println(newKasse.sum());
        System.out.println(newKasse.bezahlen(5, 20));
        System.out.println(1200-34.42);
       // System.out.println(1392.05-1185.58);

        System.out.println(newKasse.sum());

        newKasse.print();

    }

    public class Geld{
        private final double wert;
        private int anzahl;
        private final String name;
        double total ;

        public Geld(double wert, int anzahl, String name, double total) {
            this.wert = wert;
            this.anzahl = anzahl;
            this.name = name;
            this.total = total;
        }

        @Override
        public String toString() {
            return "Geld{" +
                    "wert=" + wert +
                    ", anzahl=" + anzahl +
                    ", name='" + name + '\'' +
                    ", total=" + total +
                    '}';
        }
    }

    public class Kasse{
        private List<Geld> gelds;


        public Kasse() {
            gelds = new ArrayList<>();
        }

        public void addGeld(Geld geld) {
            this.gelds .add(geld);
        }

        public double sum() {
            return gelds.stream().mapToDouble((geld) -> geld.total).sum();
        }

        public double bezahlen(double productprice, double betrag) {
            List<Geld> newList = new ArrayList(gelds);
            if(productprice > betrag) {
                System.out.println("Der bezahlte Betrag reicht nicht aus. Es fehlt noch "+ (productprice-betrag) +" Euro!");
                return betrag;
            } else if ( (productprice-betrag) > sum() ) {
                System.out.println("Der Bestand der Kasse reicht nicht aus. Es fehlt noch "+ ((productprice-betrag) - sum()) +" Euro!");
                return betrag;
            } else {
                double difference = (betrag - productprice);
                for( int i = newList.size()-1; i >= 0; i--) {
                    Geld geld = newList.get(i);
                    while ( difference >= geld.wert) {
                            if (geld.anzahl > 0) {
                                difference -= geld.wert;
                                newList.get(i).anzahl--;
                                newList.get(i).total -= gelds.get(i).wert;
                            }

                    }
                }
                if( difference > 0.01) throw new RuntimeException("Sie müssen die Kasse nachfüllen!");
                gelds = newList;
                return (betrag - productprice);
            }
        }

        public void print(){
            for (Geld geld : gelds) {
                System.out.println(geld);
            }
        }
    }


    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        testClass.run();
    }



    public static int average(List<Person> persons){
        final int[] counter = {0};
        int sum =  persons.stream().mapToInt((p1) -> {
                    counter[0]++;
                    return p1.getAge();
                }
        ).sum();
        return (int ) Math.round((double) sum / counter[0]);
    }

    public static int median(List<Person> p_persons){
        List<Person> persons = new ArrayList<>(p_persons);
        Collections.sort(persons);
        int counter = persons.size();
        int result;
        if( counter % 2 == 0) {
            result = ((persons.get(counter/ 2).getAge() + persons.get((counter/2) -1).getAge()) / 2);
        } else{
            result = persons.get(counter/ 2).getAge();
        }
        return result;
    }

}
