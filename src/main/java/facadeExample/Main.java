package facadeExample;

import java.io.File;

public class Main {

    // Фасад — это структурный паттерн,
    // который предоставляет простой (но урезанный) интерфейс к сложной системе объектов,
    // библиотеке или фреймворку.

    public static void main(String[] args) {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("YouTubeVideo.ogg", "mp4");
    }
}
