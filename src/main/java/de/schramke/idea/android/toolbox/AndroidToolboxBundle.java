package de.schramke.idea.android.toolbox;

import com.intellij.CommonBundle;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.ResourceBundle;

public class AndroidToolboxBundle {
    private static final String BUNDLE = "AndroidToolboxBundle";
    private static Reference<ResourceBundle> ourBundle;

    private AndroidToolboxBundle() {
    }

    public static String message(String key, Object... params) {
        return CommonBundle.message(getBundle(), key, params);
    }

    private static ResourceBundle getBundle() {
        ResourceBundle bundle = null;
        if (ourBundle != null) {
            bundle = ourBundle.get();
        }
        if (bundle == null) {
            bundle = ResourceBundle.getBundle(BUNDLE);
            ourBundle = new SoftReference<ResourceBundle>(bundle);
        }
        return bundle;
    }
}
