package ru.dvsokolov.cli;

import ru.dvsokolov.cli.service.Application;
import ru.dvsokolov.cli.utils.*;

public class Main {

    public static void main(String[] args) {
        IO io = new IOImpl(System.out, System.in);
        AppMenu appMenu = new AppMenuImpl(io);
        Application application = new Application(io, appMenu);
        application.run();
    }
}
