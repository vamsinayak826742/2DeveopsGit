document.addEventListener('DOMContentLoaded', function () {
    const ruleForm = document.getElementById('ruleForm');
    const ruleNameInput = document.getElementById('ruleName');
    const ruleExpressionInput = document.getElementById('ruleExpression');
    const rulesTableBody = document.querySelector('#rulesTable tbody');
    const evaluateBtn = document.getElementById('evaluateBtn');
    const evaluationResult = document.getElementById('evaluationResult');

    const mongoDBUrl = 'http://localhost:8080/rules';

    function showAlert(message, type = 'info') {
        alert(`${type.toUpperCase()}: ${message}`);
    }

    function clearInputFields() {
        ruleNameInput.value = '';
        ruleExpressionInput.value = '';
        document.getElementById('userAge').value = '';
        document.getElementById('userIncome').value = '';
        document.getElementById('userDepartment').value = '';
        document.getElementById('userExperience').value = '';
    }

    ruleForm.addEventListener('submit', function (e) {
        e.preventDefault();
        const ruleName = ruleNameInput.value.trim();
        const ruleExpression = ruleExpressionInput.value.trim();

        if (ruleName && ruleExpression) {
            const newRule = { ruleName, ruleExpression };

            fetch(mongoDBUrl, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(newRule)
            })
            .then(response => response.json())
            .then(data => {
                showAlert('Rule created successfully!', 'success');
                addRuleToTable(data);
                clearInputFields();
            })
            .catch(error => showAlert('Error creating rule', 'error'));
        } else {
            showAlert('Please fill out all fields', 'warning');
        }
    });

    function addRuleToTable(rule) {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${rule.ruleName}</td>
            <td>${rule.ruleExpression}</td>
            <td>
                <button class="action-btn update" onclick="updateRule('${rule.id}')">Update</button>
                <button class="action-btn" onclick="deleteRule('${rule.id}')">Delete</button>
            </td>
        `;
        rulesTableBody.appendChild(row);
    }

    function fetchExistingRules() {
        fetch(mongoDBUrl)
            .then(response => response.json())
            .then(data => {
                data.forEach(rule => addRuleToTable(rule));
            })
            .catch(error => showAlert('Error fetching rules', 'error'));
    }

    evaluateBtn.addEventListener('click', function () {
        const age = document.getElementById('userAge').value;
        const income = document.getElementById('userIncome').value;
        const department = document.getElementById('userDepartment').value;
        const experience = document.getElementById('userExperience').value;

        if (age && income && department && experience) {
            const evaluationData = {
                age: Number(age),
                income: Number(income),
                department,
                experience: Number(experience)
            };

            fetch(`${mongoDBUrl}/evaluate`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(evaluationData)
            })
            .then(response => response.json())
            .then(result => {
                const isEligible = result.eligible ? 'Eligible' : 'Not Eligible';
                evaluationResult.innerHTML = `<strong>${isEligible}</strong>`;
                evaluationResult.style.display = 'block';
                clearInputFields();
            })
            .catch(error => showAlert('Error evaluating eligibility', 'error'));
        } else {
            showAlert('Please fill out all fields for evaluation', 'warning');
        }
    });

    window.deleteRule = function (id) {
        fetch(`${mongoDBUrl}/${id}`, { method: 'DELETE' })
        .then(response => {
            if (response.ok) {
                showAlert('Rule deleted successfully', 'success');
                rulesTableBody.innerHTML = '';
                fetchExistingRules();
            } else {
                throw new Error('Failed to delete rule');
            }
        })
        .catch(error => showAlert(`Error deleting rule: ${error.message}`, 'error'));
    };

    window.updateRule = function (id) {
        const updatedRuleName = prompt('Enter new rule name:');
        const updatedRuleExpression = prompt('Enter new rule expression:');

        if (updatedRuleName && updatedRuleExpression) {
            const updatedRule = { ruleName: updatedRuleName, ruleExpression: updatedRuleExpression };

            fetch(`${mongoDBUrl}/${id}`, {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(updatedRule)
            })
            .then(response => {
                if (response.ok) {
                    showAlert('Rule updated successfully', 'success');
                    rulesTableBody.innerHTML = '';
                    fetchExistingRules();
                } else {
                    throw new Error('Failed to update rule');
                }
            })
            .catch(error => showAlert(`Error updating rule: ${error.message}`, 'error'));
        } else {
            showAlert('Update canceled or incomplete', 'warning');
        }
    };

    fetchExistingRules();
});
