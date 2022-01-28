package wladson.edy;

import wladson.edy.view.CausaRebeldeView;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class CausaRebeldeApplication {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        CausaRebeldeView causaRebelde = new CausaRebeldeView();
        causaRebelde.askInformacoes();
    }
}
