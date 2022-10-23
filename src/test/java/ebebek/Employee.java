package ebebek;

public class Employee {

    private String name;
    private int baslangicYili;
    private double maasi, vergi, maasArtisi, vergiArtibonusMaas, toplamMaas, bonus;
    int calismaSaati;

    public Employee() {

    }

    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.maasi = salary;
        this.calismaSaati = workHours;
        this.baslangicYili = hireYear;
    }

    public void setVergiArtibonusMaas(double vergiArtibonusMaas) {
        this.vergiArtibonusMaas = vergiArtibonusMaas;
    }

    public void setToplamMaas(double toplamMaas) {
        this.toplamMaas = toplamMaas;
    }

    public double tax(double maasi) {
        if (maasi < 1.000) {
            this.vergi = 0.0;
        } else if (maasi > 1.000) {
            this.vergi = (maasi * 3 / 100);
        }
        return vergi;
    }

    public double bonus(int calismaSaati) {
        if (calismaSaati > 40) {
            this.bonus = (calismaSaati - 40) * 30;
        }
        return bonus;
    }

    public double raiseSalary(int baslangicYili) {
        int yil = 2021;
        this.maasArtisi = 0;
        if ((yil - baslangicYili) < 10) {
            maasArtisi = maasi * 5 / 100;
        } else if ((yil - baslangicYili) > 9 && (yil - baslangicYili) < 20) {
            maasArtisi = maasi * 10 / 100;
        } else if ((yil - baslangicYili) > 19) {
            maasArtisi = maasi * 15 / 100;
        }
        return maasArtisi;
    }

    @Override
    public String toString() {
        return
                        "Adı : " + name + "\n" +
                        "Maaşı : " + maasi + "\n" +
                        "Çalışma Saati : " + calismaSaati + "\n" +
                        "Başlangıç Yılı : " + baslangicYili + "\n" +
                        "Vergi : " + vergi + "\n" +
                        "Bonus : " + bonus + "\n" +
                        "Maaş Artışı : " + maasArtisi + "\n" +
                        "Vergi ve Bonuslar ile birlikte maaş : " + vergiArtibonusMaas + "\n" +
                        "Toplam Maas : " + toplamMaas;
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Kemal", 2000.0, 45, 1985);
        employee.bonus(45);
        employee.raiseSalary(1985);
        employee.tax(2000.0);
        employee.setVergiArtibonusMaas(employee.vergi + (employee.bonus - employee.vergi) + (employee.maasi - employee.vergi));
        employee.setToplamMaas(employee.vergi + (employee.bonus - employee.vergi) + (employee.maasi - employee.vergi) + employee.maasArtisi);
        System.out.println(employee);
    }
}