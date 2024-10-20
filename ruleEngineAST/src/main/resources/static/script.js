const rules = [];

function createRule() {
    const ruleName = document.getElementById("ruleName").value;
    const ruleExpression = document.getElementById("ruleExpression").value;

    if (ruleName && ruleExpression) {
        rules.push({ ruleName, ruleExpression });
        document.getElementById("ruleName").value = '';
        document.getElementById("ruleExpression").value = '';
        displayRules();
		showAlert("Rule created successfully!");
    }
}

function displayRules() {
    const tbody = document.getElementById("rulesTableBody");
    tbody.innerHTML = '';

    rules.forEach((rule, index) => {
        const row = `<tr>
            <td>${rule.ruleName}</td>
            <td>${rule.ruleExpression}</td>
            <td>
                <button onclick="updateRule(${index})">Update</button>
                <button onclick="deleteRule(${index})">Delete</button>
            </td>
        </tr>`;
        tbody.innerHTML += row;
    });
}

function showAlert(message) {
    const alertBox = document.getElementById("alertBox");
    const alertMessage = document.getElementById("alertMessage");
    alertMessage.innerText = message;
    alertBox.style.display = 'block';
}

function closeAlert() {
    const alertBox = document.getElementById("alertBox");
    alertBox.style.display = 'none';
}


function updateRule(index) {
    const ruleName = prompt("Enter new Rule Name:", rules[index].ruleName);
    const ruleExpression = prompt("Enter new Rule Expression:", rules[index].ruleExpression);

    if (ruleName && ruleExpression) {
        rules[index] = { ruleName, ruleExpression };
        displayRules();
    }
}



function deleteRule(index) {
    rules.splice(index, 1);
    displayRules();
}

function evaluateRule() {
    const age = parseInt(document.getElementById("age").value);
    const department = document.getElementById("department").value;
    const salary = parseFloat(document.getElementById("salary").value);
    const experience = parseInt(document.getElementById("experience").value);

    const resultBox = document.getElementById("evaluationResult");
    resultBox.innerHTML = `Evaluating for Age: ${age}, Department: ${department}, Salary: ${salary}, Experience: ${experience}`;
	// Show alert for evaluation
	   showAlert("Evaluation completed!");
    // Convert user input into JSON format for evaluation
    const userInput = {
        age: age,
        department: department,
        salary: salary,
        experience: experience
    };

    // Check if any rule is matched
    let isEligible = false;
    for (const rule of rules) {
        if (evaluateExpression(rule.ruleExpression, userInput)) {
            isEligible = true;
            break;
        }
    }

	// Show alert for evaluation
	   showAlert("Evaluation completed!");
    // Display eligibility result
	
	
    setTimeout(() => {
        const eligibilityText = isEligible ? "User is eligible." : "User is not eligible.";
        resultBox.innerHTML += `<div style="font-weight: bold; text-align: center;">${eligibilityText}</div>`;
        clearInputs();
    }, 1000); // Show eligibility after 1 second
}

function evaluateExpression(expression, data) {
    // This is a basic implementation of an expression evaluator
    // Use a library or more robust method for complex expressions
    try {
        return eval(expression.replace(/(\w+)/g, (_, key) => data[key]));
    } catch (error) {
        console.error("Error evaluating expression:", error);
        return false;
    }
}

function clearInputs() {
    document.getElementById("age").value = '';
    document.getElementById("department").value = '';
    document.getElementById("salary").value = '';
    document.getElementById("experience").value = '';
}
