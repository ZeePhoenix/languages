package zac.languages.languages;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LanguageController {
    private final LanguageService langService;

    public LanguageController(LanguageService langService){
        this.langService = langService;
    }

    @RequestMapping(value="/languages", method=RequestMethod.GET)
    public String index(Model model){
        List<Language> langs = langService.allLanguages();
        model.addAttribute("languages", langs);
        return "index.jsp";
    }

    @RequestMapping(value="/languages", method = RequestMethod.POST)
    public Language create(@RequestParam(value="name")String name, @RequestParam(value="creator")String creator, @RequestParam(value="version")String version){
        Language lang = new Language(name, creator, version);
        return langService.createLanguage(lang);
    }
}
