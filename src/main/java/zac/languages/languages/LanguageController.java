package zac.languages.languages;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LanguageController {
    private final LanguageService langService;

    public LanguageController(LanguageService langService){
        this.langService = langService;
    }

    @RequestMapping("/")
    public String indexRoute(){
        return "redirect:/languages";
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

    @RequestMapping(value="/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model){
        Language lang = langService.findLanguage(id);
        model.addAttribute("language", lang);
        return "edit.jsp";
    }

    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") Language lang, BindingResult result){
        if (result.hasErrors()){
            return "edit.jsp";
        } else {
            langService.updateLanguage(lang);
            return "redirect:/languages";
        }
    }
}
