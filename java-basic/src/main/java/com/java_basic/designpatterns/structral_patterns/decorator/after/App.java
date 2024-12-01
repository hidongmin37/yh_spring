package com.java_basic.designpatterns.structral_patterns.decorator.after;

public class App {

    private static boolean isEnableSpamFilter = true;
    private static boolean isEnableTrimming = true;

    public static void main(String[] args) {
        CommentService commentService = new DefaultCommentService();

        if (isEnableSpamFilter) {
            commentService = new SpamFilteringCommentDecorator(commentService);
        }

        if (isEnableTrimming) {
            commentService = new TrimmingCommentDecorator(commentService);
        }

        Client client = new Client(commentService);
        client.writeComment("오징어게임");
        client.writeComment("보는게 하는거 보다 재밌을 수가 없지...");
        client.writeComment("http://whiteship.me");
    }

}
