@Controller
class ThisWillActuallyRun {

    @RequestMapping("/")
    @ResponseBody String home() {
        "Hello Simona!"
    }

    @RequestMapping("/bye")
    @ResponseBody String home2() {
        "Bye Simona!"
    }
}
