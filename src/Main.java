import java.util.Scanner;

public class Main {

    public static class Employee {
        // Çalışanın bilgilerini tutuyoruz
        public String name;
        public double salary;
        public int workHours;
        public int hireYear;

        public  Employee(String name, double salary, int workHours, int hireYear){
            this.name = name;
            this.salary = salary;
            this.workHours = workHours;
            this.hireYear = hireYear;

        }
         // vergi hesaplama methodu
        public double tax(){
            if (salary < 1000) {
                return 0;
            }else{
                return salary * 0.03;
            }
        }
        // bonus hesaplama methodu
        public double bonus() {
            if (workHours > 40){
                return (workHours - 40) * 30;
            }
            return 0;
        }
        // maaş artışı hesaplama methodu
        public double raiseSalary() {
            int yearsWorked = 2021 - hireYear ;
            if (yearsWorked < 10) {
                return salary * 0.05;
            } else if (yearsWorked >= 10 && yearsWorked < 20) {
                return salary * 0.10;
            }else{
                return salary * 0.15;
            }
        }
        // çalışan bilgilerini ekrana yazdıran method
        public String toString() {
            double tax = tax();
            double bonus = bonus();
            double raise = raiseSalary();
            double salaryAfterTaxAndBonus = salary - tax + bonus ;
            double totalSalary = salaryAfterTaxAndBonus + raise;

            return "Adı : " + name + "\n" +
                    "Maaşı : " + salary + "\n" +
                    "Çalışma Saati : " + workHours + "\n" +
                    "Başlangıç Yılı : " + hireYear + "\n" +
                    "Vergi : " + tax + "\n" +
                    "Bonus : " + bonus + "\n" +
                    "Maaş Artışı : " + raise + "\n" +
                    "Vergi ve Bonuslar ile birlikte maaş : " + salaryAfterTaxAndBonus + "\n" +
                    "Toplam Maaş : " + totalSalary;

        }
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // kullanıcıdan bilgiler alınır
            System.out.print("Çalışanın adı: ");
            String name = scanner.nextLine();

            System.out.print("Çalışanın maaşı: ");
            double salary = scanner.nextDouble();

            System.out.print("Haftalık çalışma saati: ");
            int workHours = scanner.nextInt();

            System.out.print("İşe başlama yılı: ");
            int hireYear = scanner.nextInt();

            Employee emp = new Employee(name, salary, workHours, hireYear);

            // kullanıcının bilgileri ekrana yazdırılır
            System.out.println(emp.toString());
        }
    }
}