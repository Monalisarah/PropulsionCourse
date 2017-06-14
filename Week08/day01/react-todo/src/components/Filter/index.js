import React, { Component } from 'react';

import './index.css';

class Filter extends Component {

  handleFilterChange = (e) => {
    this.props.onFilterChange(e.currentTarget.id);
  }

  isChecked = (filter) => filter === this.props.selectedFilter

  render() {
    return (
      <div className="Filter">
        <input
          type="radio"
          name="filter"
          id="all"
          checked={ this.isChecked('all') }
          onChange={ this.handleFilterChange }
        />
        <label htmlFor="all">All</label>
        <input
          type="radio"
          name="filter"
          id="completed"
          checked={ this.isChecked('completed') }
          onChange={ this.handleFilterChange }
        />
        <label htmlFor="completed">Completed</label>
        <input
          type="radio"
          name="filter"
          id="uncompleted"
          checked={ this.isChecked('uncompleted') }
          onChange={ this.handleFilterChange }
        />
        <label htmlFor="uncompleted">Uncompleted</label>
      </div>
    )
  }
}

Filter.propTypes = {
  selectedFilter: React.PropTypes.string.isRequired,
  onFilterChange: React.PropTypes.func.isRequired
}

export default Filter;
