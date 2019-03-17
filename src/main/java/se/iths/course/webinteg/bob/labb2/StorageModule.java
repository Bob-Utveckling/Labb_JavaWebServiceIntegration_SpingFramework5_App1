//This code, through Martins's code on DIExample
//see https://github.com/kappsegla/DIExample

package se.iths.course.webinteg.bob.labb2;

import com.google.inject.AbstractModule;

public class StorageModule extends AbstractModule {

    @Override
    protected void configure() {

        //bind(AnmalanController.class);
        //bind(Storage.class).to(SqLiteStorage.class);
    }
}
