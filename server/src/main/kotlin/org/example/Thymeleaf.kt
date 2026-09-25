fun Application.configureThymeleaf(){
    install(Thymeleaf) {
        setTemplateResolver(ClassLoaderTemplateResolver().apply()) {
            prefix = "templates/thymeleaf/"
            suffix = ".html"
            characterEncoding = "utf-8"
        }
    }
}