function showModal(type) {
    var modalBody = document.querySelector('.modal-body');
    modalBody.innerHTML = '';

    if (type === 'text') {
        modalBody.innerHTML = `
      <div class="form-group">
        <label for="text-input">Champ de texte :</label>
        <input type="text" class="form-control" id="text-input">
      </div>
    `;
    } else if (type === 'dropdown') {
        modalBody.innerHTML = `
      <div class="form-group">
        <label for="dropdown-select">Menu déroulant :</label>
        <select class="form-control" id="dropdown-select">
          <option value="option1">Option 1</option>
          <option value="option2">Option 2</option>
          <option value="option3">Option 3</option>
        </select>
      </div>
    `;
    }
}

const typeForm = document.getElementById("typeForm");
const typeSelect = document.getElementById("typeId");

function switchFormType() {


}
