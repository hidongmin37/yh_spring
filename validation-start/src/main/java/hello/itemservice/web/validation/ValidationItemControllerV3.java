package hello.itemservice.web.validation;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/validation/v3/items")
@RequiredArgsConstructor
public class ValidationItemControllerV3 {

    private final ItemRepository itemRepository;
    private final ItemValidator itemValidator;

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        dataBinder.addValidators(itemValidator);
    }


    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "validation/v3/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "validation/v3/item";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("item", new Item());
        return "validation/v3/addForm";
    }

//    @PostMapping("/add")
    public String addItemV1(@ModelAttribute Item item, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {



        //검증 로직, 아이템 이름
        if (!StringUtils.hasText(item.getItemName())) {
            bindingResult.addError(new FieldError("item","itemName","상품 이름은 필수입니다."));
        }

        //가격
        if (item.getPrice() == null || item.getPrice() < 1000 || item.getPrice() > 1000000) {
            bindingResult.addError(new FieldError("item","price","가격은 1,000원에서 100만원까지 허용합니다."));
        }

        //수량
        if (item.getQuantity() == null || item.getQuantity() >= 9999) {
            bindingResult.addError(new FieldError("item","quantity","수량은 최대 9,999까지 허용합니다."));
        }

        //특정 필드가 아닌 복합룰 검증
        if(item.getPrice() != null && item.getQuantity() != null){
            int resultPrice = item.getPrice() * item.getQuantity();
            if (resultPrice < 10000){
                bindingResult.addError(new ObjectError("item","가격 * 수량의 값은 1만원 이상어이야 합니다. 현재 값은 =" + resultPrice));
            }
        }


        // 검증에 실패하면 다시 입력 폼으로
        if(bindingResult.hasErrors()){
//            model.addAttribute("bindingResult", bindingResult); 안담아도 뷰로 넘어감
            log.info(" bindingResult log={}", bindingResult);
            return "validation/v3/addForm";
        }

        Item savedItem = itemRepository.save(item);

        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/validation/v3/items/{itemId}";
    }

//    @PostMapping("/add")
    public String addItemV2(@ModelAttribute Item item, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {

        //검증 로직, 아이템 이름
        if (!StringUtils.hasText(item.getItemName())) {
            bindingResult.addError(new FieldError("item","itemName",item.getItemName(),false,null,null,"상품 이름은 필수입니다."));
        }

        //가격
        if (item.getPrice() == null || item.getPrice() < 1000 || item.getPrice() > 1000000) {
            bindingResult.addError(new FieldError("item","price",item.getPrice(),false,null,null,"가격은 1,000원에서 100만원까지 허용합니다."));
        }

        //수량
        if (item.getQuantity() == null || item.getQuantity() >= 9999) {
            bindingResult.addError(new FieldError("item","quantity",item.getQuantity(),false,null,null,"수량은 최대 9,999까지 허용합니다."));
        }

        //특정 필드가 아닌 복합룰 검증
        if(item.getPrice() != null && item.getQuantity() != null){
            int resultPrice = item.getPrice() * item.getQuantity();
            if (resultPrice < 10000){
                bindingResult.addError(new ObjectError("item",null,null,"가격 * 수량의 값은 1만원 이상어이야 합니다. 현재 값은 =" + resultPrice));
            }
        }


        // 검증에 실패하면 다시 입력 폼으로
        if(bindingResult.hasErrors()){
//            model.addAttribute("bindingResult", bindingResult); 안담아도 뷰로 넘어감
            log.info(" bindingResult log={}", bindingResult);
            return "validation/v3/addForm";
        }

        Item savedItem = itemRepository.save(item);

        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/validation/v3/items/{itemId}";
    }

//    @PostMapping("/add")
    public String addItemV3(@ModelAttribute Item item, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {

        log.info("objectName={}",bindingResult.getObjectName());
        log.info("target={}",bindingResult.getTarget());

        //검증 로직, 아이템 이름
        if (!StringUtils.hasText(item.getItemName())) {
            bindingResult.addError(new FieldError("item","itemName",item.getItemName(),false,new String[]{"required.item.itemName"},null,null));
        }

        //가격
        if (item.getPrice() == null || item.getPrice() < 1000 || item.getPrice() > 1000000) {
            bindingResult.addError(new FieldError("item","price",item.getPrice(),false,new String[]{"range.item.price"},new Object[]{"1,000","1,000,000"},null));
        }

        //수량
        if (item.getQuantity() == null || item.getQuantity() >= 9999) {
            bindingResult.addError(new FieldError("item","quantity",item.getQuantity(),false,new String[]{"max.item.quantity"},new Object[]{"9,999"},null));
        }

        //특정 필드가 아닌 복합룰 검증
        if(item.getPrice() != null && item.getQuantity() != null){
            int resultPrice = item.getPrice() * item.getQuantity();
            if (resultPrice < 10000){
                bindingResult.addError(new ObjectError("item",new String[]{"totalPriceMin"},new Object[]{"10,000",resultPrice},null));
            }
        }


        // 검증에 실패하면 다시 입력 폼으로
        if(bindingResult.hasErrors()){
//            model.addAttribute("bindingResult", bindingResult); 안담아도 뷰로 넘어감
            log.info(" bindingResult log={}", bindingResult);
            return "validation/v3/addForm";
        }

        Item savedItem = itemRepository.save(item);

        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/validation/v3/items/{itemId}";
    }
//    @PostMapping("/add")
    public String addItemV4(@ModelAttribute Item item, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {

        log.info("objectName={}",bindingResult.getObjectName());
        log.info("target={}",bindingResult.getTarget());


        // 맨처음에 로직을 둬서 에러를 하나만 보이게 끔함.
        if(bindingResult.hasErrors()){
//            model.addAttribute("bindingResult", bindingResult); 안담아도 뷰로 넘어감
            log.info(" bindingResult log={}", bindingResult);
            return "validation/v3/addForm";
        }

        //또 다른 검증 로직
//        ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "itemName", "required");


        //검증 로직, 아이템 이름
        if (!StringUtils.hasText(item.getItemName())) {
//            bindingResult.addError(new FieldError("item","itemName",item.getItemName(),false,new String[]{"required.item.itemName"},null,null));
            bindingResult.rejectValue("itemName","required");

        }

        //가격
        if (item.getPrice() == null || item.getPrice() < 1000 || item.getPrice() > 1000000) {
//            bindingResult.addError(new FieldError("item","price",item.getPrice(),false,new String[]{"range.item.price"},new Object[]{"1,000","1,000,000"},null));
            bindingResult.rejectValue("price","range",new Object[]{1000,1000000},null);
        }

        //수량
        if (item.getQuantity() == null || item.getQuantity() >= 9999) {
//            bindingResult.addError(new FieldError("item","quantity",item.getQuantity(),false,new String[]{"max.item.quantity"},new Object[]{"9,999"},null));
            bindingResult.rejectValue("quantity","max",new Object[]{9999},null);
        }

        //특정 필드가 아닌 복합룰 검증
        if(item.getPrice() != null && item.getQuantity() != null){
            int resultPrice = item.getPrice() * item.getQuantity();
            if (resultPrice < 10000){
//                bindingResult.addError(new ObjectError("item",new String[]{"totalPriceMin"},new Object[]{"10,000",resultPrice},null));
                bindingResult.reject("totalPriceMin",new Object[]{10000,resultPrice},null);
            }
        }


        // 검증에 실패하면 다시 입력 폼으로
        if(bindingResult.hasErrors()){
//            model.addAttribute("bindingResult", bindingResult); 안담아도 뷰로 넘어감
            log.info(" bindingResult log={}", bindingResult);
            return "validation/v3/addForm";
        }

        Item savedItem = itemRepository.save(item);

        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/validation/v3/items/{itemId}";
    }


//    @PostMapping("/add")
    public String addItemV5(@ModelAttribute Item item, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {

        itemValidator.validate(item,bindingResult);

        if(bindingResult.hasErrors()){
            log.info(" errors log={}", bindingResult);
            return "validation/v3/addForm";
        }
        Item savedItem = itemRepository.save(item);

        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/validation/v3/items/{itemId}";
    }

    @PostMapping("/add")
    public String addItemV6(@Validated @ModelAttribute Item item, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {


        if(bindingResult.hasErrors()){
            log.info(" errors log={}", bindingResult);
            return "validation/v3/addForm";
        }
        Item savedItem = itemRepository.save(item);

        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/validation/v3/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "validation/v3/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Item item) {
        itemRepository.update(itemId, item);
        return "redirect:/validation/v3/items/{itemId}";
    }

}

