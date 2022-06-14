package site.metacoding.test.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.test.domain.Weather;
import site.metacoding.test.domain.WeatherRepository;

@RequiredArgsConstructor
@Controller
public class WeatherController {

    private final WeatherRepository weatherRepository;

    @GetMapping("/weather")
    public String list(Model model) {
        List<Weather> weathers = weatherRepository.findAll();
        model.addAttribute("weather", weathers);
        return "/list";
    }
}
