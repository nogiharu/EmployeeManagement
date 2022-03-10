check = (employeeId,name) => {
    let form = document.getElementsByTagName('form')[0]
    if (confirm('この作業は修正できません。本当によろしいですか。')) {
        form.action = "/task/delete/" + employeeId;
        form.method = "get";
        form.submit();
    }
}



