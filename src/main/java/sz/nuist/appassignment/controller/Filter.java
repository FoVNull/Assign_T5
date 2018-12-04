package sz.nuist.appassignment.controller;

public class Filter {
    public boolean Filter(String str){
        str = str.toLowerCase();//统一转为小写
        String badStr = "'|select|update|and|or|delete|insert|truncate|char|into"
                + "|substr|declare|exec|master|drop|execute|"
                + "union|;|--|+|,|like|//|/|%|#|*|$|@|\"|http|cr|lf|<|>|(|)";
        String[] badStrs = badStr.split("\\|");
        for (int i = 0; i < badStrs.length; i++) {
            if (str.indexOf(badStrs[i]) >= 0) {
                return true;
            }
        }
        return false;
    }
}
