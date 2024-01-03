package hello.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class HelloImportSelector implements ImportSelector {



    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        // 파일리스트나 조건문으로 동적으로 가능
        return new String[]{"hello.selector.HelloConfig"};
    }
}
