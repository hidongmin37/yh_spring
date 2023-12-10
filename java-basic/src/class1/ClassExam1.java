package class1;

public class ClassExam1 {
    public static void main(String[] args) {
        MovieReview review1 = new MovieReview();
        review1.title = "인셉션";
        review1.review = "인생은 무한루프";

        MovieReview review2 = new MovieReview();
        review2.title = "어바웃 타임";
        review2.review = "인생 시간 영화";

        MovieReview[] movies = {review1, review2};
        for (MovieReview movie : movies) {
            System.out.println("영화 제목 : " +  movie.title);
            System.out.println("영화 리뷰 : " + movie.review);
        }
    }
}
