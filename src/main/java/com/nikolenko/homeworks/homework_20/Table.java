package com.nikolenko.homeworks.homework_20;

public class Table {
    Philosopher platon;
    Philosopher aristotel;
    Philosopher diogen;
    Fork platonAristotel;
    Fork aristotelDiogen;
    Fork diogenPlaton;

    Thread platonTread;
    Thread aristotelTread;
    Thread diogenTread;

    Table() {
        platonAristotel = new Fork("platonAristotel");
        aristotelDiogen = new Fork("aristotelDiogen");
        diogenPlaton = new Fork("diogenPlaton");

        platon = new Philosopher("Platon", platonAristotel, diogenPlaton);
        aristotel = new Philosopher("Aristotel", aristotelDiogen, platonAristotel);
        diogen = new Philosopher("Diogen", diogenPlaton, aristotelDiogen);

        while (platon.getCycleCounter() + aristotel.getCycleCounter() + diogen.getCycleCounter() < 10) {
            if (platon.isSleeping() && aristotel.isSleeping() && diogen.isSleeping()) {
                platonTread = new Thread(platon);
                platonTread.setName("Platon");
                platonTread.start();
                aristotelTread = new Thread(aristotel);
                aristotelTread.setName("Aristotel");
                aristotelTread.start();
                diogenTread = new Thread(diogen);
                diogenTread.setName("Diogen");
                diogenTread.start();
            }

            try {
                Thread.sleep(10);
            } catch (java.lang.InterruptedException e) {
                System.out.println((e.toString()));
            }
        }
    }
}
