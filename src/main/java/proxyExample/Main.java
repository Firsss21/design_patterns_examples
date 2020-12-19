package proxyExample;

public class Main {

    //Заместитель — это объект,
    // который выступает прослойкой между клиентом и реальным сервисным объектом.
    // Заместитель получает вызовы от клиента,
    // выполняет свою функцию (контроль доступа, кеширование, изменение запроса и прочее),
    // а затем передаёт вызов сервисному объекту.

    public static void main(String[] args) {
        YouTubeDownloader naiveDownloader = new YouTubeDownloader(new ThirdPartyYouTubeClass());
        YouTubeDownloader smartDownloader = new YouTubeDownloader(new YouTubeCacheProxy());

        long naive = test(naiveDownloader);
        long smart = test(smartDownloader);
        System.out.print("Time saved by caching proxy: " + (naive - smart) + " ms");

    }

    private static long test(YouTubeDownloader downloader) {
        long startTime = System.currentTimeMillis();

        downloader.renderPopularVideos();
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("dancesvideoo");

        // пользователи посещают ту же страницу
        downloader.renderVideoPage("dancesvideoo");
        downloader.renderVideoPage("catzzzzzzzzz");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Time elapsed: " + estimatedTime + " ms\n");
        return estimatedTime;
    }
}
