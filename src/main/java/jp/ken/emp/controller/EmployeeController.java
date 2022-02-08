package jp.ken.emp.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.ken.emp.model.EmployeeModel;
import jp.ken.emp.model.ListDataModel;


@Controller
public class EmployeeController {
	private LocalDate ld = LocalDate.now();

	private List<ListDataModel> getBYearList() {

		List<ListDataModel> bYearList = new ArrayList<ListDataModel>();
		for (int i = 1970; i <= ld.getYear(); i++) {
			bYearList.add(new ListDataModel(String.valueOf(i), String.valueOf(i)));
		}
		return bYearList;
	}

	private List<ListDataModel> getEYearList() {

		List<ListDataModel> eYearList = new ArrayList<ListDataModel>();
		for (int i = 2000; i <= ld.getYear(); i++) {
			eYearList.add(new ListDataModel(String.valueOf(i), String.valueOf(i)));
		}
		return eYearList;
	}

	private List<ListDataModel> getMonthList() {

		List<ListDataModel> yearList = new ArrayList<ListDataModel>();
		for (int i = 1; i <= 12; i++) {
			yearList.add(new ListDataModel(String.valueOf(i), String.valueOf(i)));
		}
		return yearList;
	}
	private List<ListDataModel> getDaysList() {

		List<ListDataModel> yearList = new ArrayList<ListDataModel>();
		for (int i = 1; i <= 31; i++) {
			yearList.add(new ListDataModel(String.valueOf(i), String.valueOf(i)));
		}
		return yearList;
	}

	private List<ListDataModel> getRank() {

		List<ListDataModel> rankList = new ArrayList<ListDataModel>();
		char ch = 'A';
		for (int i = 0; i <= ('Z'-'A') ; i++) {
			rankList.add(new ListDataModel(String.valueOf(ch), String.valueOf(ch)));
			ch++;
		}
		return rankList;
	}
	private List<ListDataModel> getCapacitiesList() {
		List<ListDataModel> capacitiesList= new ArrayList<ListDataModel>();
		capacitiesList.add(new ListDataModel("ITパスポート", "ipass"));
		capacitiesList.add(new ListDataModel("基本情報技術者試験", "kihon"));
		capacitiesList.add(new ListDataModel("応用情報技術者試験", "oyo"));
		capacitiesList.add(new ListDataModel("秘書検定３級", "hisho3"));
		capacitiesList.add(new ListDataModel("秘書検定２級", "hisho2"));
		capacitiesList.add(new ListDataModel("日商簿記３級", "boki3"));
		capacitiesList.add(new ListDataModel("日商簿記２級", "boki2"));
		capacitiesList.add(new ListDataModel("ビジネス文書検定３級", "business3"));
		capacitiesList.add(new ListDataModel("ビジネス文書検定２級", "business3"));
		capacitiesList.add(new ListDataModel("その他", "other"));

		return capacitiesList;
	}
	private List<ListDataModel> getPostList() {
		List<ListDataModel> postList= new ArrayList<ListDataModel>();
		postList.add(new ListDataModel("開発部", "kaihatsu"));
		postList.add(new ListDataModel("人事部", "kihon"));
		postList.add(new ListDataModel("営業部", "oyo"));
		postList.add(new ListDataModel("総務部", "hisho3"));
		postList.add(new ListDataModel("経理部", "hisho2"));


		return postList;
	}

	@RequestMapping(value = "regist", method = RequestMethod.GET)
	public String members(Model model,EmployeeModel employeeModel) {
		// emp.setRank("B");
		model.addAttribute("bYears", getBYearList());
		model.addAttribute("eYears", getEYearList());
		model.addAttribute("months", getMonthList());
		model.addAttribute("days", getDaysList());
		model.addAttribute("rank",getRank() );
//		model.addAttribute("sample", emp.setRank("B"));
		model.addAttribute("capacities",getCapacitiesList());
		model.addAttribute("post", getPostList());


		return "employeeRegistration";
	}
	@RequestMapping(value = "regist",method = RequestMethod.POST)
	public String bbb(@Valid EmployeeModel emp,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "employeeRegistration";
		}
		return "employeeConfirm";
	}
}
