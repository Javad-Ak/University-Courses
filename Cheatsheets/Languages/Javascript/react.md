React.js is a powerful JavaScript library for building user interfaces, particularly single-page applications. It is component-based, making it easier to build, manage, and scale complex UIs by breaking them down into smaller, reusable parts. Below is an overview of React's core concepts, including function components, states, props, passing props, routing, and more.

### 1. **Components in React**

In React, **components** are the building blocks of any React application. A component is a JavaScript function or class that optionally accepts inputs (i.e., `props`) and returns a React element describing what should appear on the UI.

There are two types of components in React:
- **Function Components**: The more common type nowadays due to the introduction of hooks. Function components are simply JavaScript functions that return JSX.
- **Class Components**: A more traditional way to define components, which extends `React.Component` and requires a `render()` method to return JSX.

#### Function Component Example:

```jsx
import React from 'react';

function Greeting() {
  return <h1>Hello, World!</h1>;
}

export default Greeting;
```

### 2. **JSX (JavaScript XML)**

React uses JSX to define what the UI should look like. It is a syntax extension that allows you to write HTML-like code directly in JavaScript.

Example of JSX:
```jsx
const element = <h1>Hello, JSX!</h1>;
```

### 3. **Props (Properties)**

**Props** are inputs to React components. They are passed from a parent component to a child component and are immutable, meaning the child cannot modify them.

Example of Passing Props:
```jsx
function Welcome(props) {
  return <h1>Hello, {props.name}</h1>;
}

function App() {
  return <Welcome name="Alice" />;
}
```

In the above example, `name="Alice"` is passed as a prop to the `Welcome` component.

### 4. **State**

The **state** in React is an object that holds some information that may change over the lifecycle of the component. Unlike props, state is managed within the component and can be updated.

**useState Hook** is used to add state to function components.

Example of State Management in Function Component:
```jsx
import React, { useState } from 'react';

function Counter() {
  const [count, setCount] = useState(0);

  return (
    <div>
      <p>You clicked {count} times</p>
      <button onClick={() => setCount(count + 1)}>
        Click me
      </button>
    </div>
  );
}

export default Counter;
```

Here, `useState(0)` initializes the state `count` to 0, and `setCount` is used to update the state.

### 5. **Handling Events**

React allows you to handle events like clicks, form submissions, etc., using standard JavaScript event handling.

Example of Handling Events:
```jsx
function ActionButton() {
  function handleClick() {
    alert('Button clicked!');
  }

  return <button onClick={handleClick}>Click Me</button>;
}
```

### 6. **Conditional Rendering**

Conditional rendering in React allows you to render different elements or components based on certain conditions.

Example:
```jsx
function UserGreeting(props) {
  if (props.isLoggedIn) {
    return <h1>Welcome back!</h1>;
  } else {
    return <h1>Please sign in.</h1>;
  }
}
```

### 7. **Lists and Keys**

React can render lists of elements using the `.map()` function. Each element in a list needs a unique `key` prop to help React identify which items have changed.

Example:
```jsx
function NumberList(props) {
  const numbers = props.numbers;
  const listItems = numbers.map((number) =>
    <li key={number.toString()}>{number}</li>
  );

  return <ul>{listItems}</ul>;
}

export default NumberList;
```

### 8. **Forms in React**

Forms in React work similarly to regular HTML forms, but with controlled components, React maintains control of the form elements' values in its state.

Example:
```jsx
function NameForm() {
  const [name, setName] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    alert(`Name submitted: ${name}`);
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Name:
        <input
          type="text"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
      </label>
      <button type="submit">Submit</button>
    </form>
  );
}
```

### 9. **Hooks**

React Hooks are special functions that allow you to use state and other React features in function components without needing to write a class.

- **`useState`**: Manages state in a function component.
- **`useEffect`**: Side-effects management, such as fetching data or subscribing to services.
  
Example using `useEffect`:
```jsx
import React, { useState, useEffect } from 'react';

function Timer() {
  const [count, setCount] = useState(0);

  useEffect(() => {
    const timer = setInterval(() => {
      setCount((prevCount) => prevCount + 1);
    }, 1000);

    return () => clearInterval(timer);  // Cleanup on unmount
  }, []);

  return <h1>Seconds: {count}</h1>;
}

export default Timer;
```

### 10. **Routing with React Router**

React Router is a library for managing routes in a React application, allowing you to create multi-page apps while still leveraging the advantages of a single-page app.

Install React Router:
```bash
npm install react-router-dom
```

Example using React Router:
```jsx
import React from 'react';
import { BrowserRouter as Router, Route, Link, Switch } from 'react-router-dom';

function Home() {
  return <h2>Home</h2>;
}

function About() {
  return <h2>About</h2>;
}

function App() {
  return (
    <Router>
      <nav>
        <Link to="/">Home</Link>
        <Link to="/about">About</Link>
      </nav>

      <Switch>
        <Route exact path="/" component={Home} />
        <Route path="/about" component={About} />
      </Switch>
    </Router>
  );
}

export default App;
```

### 11. **Context API**

The **Context API** allows you to pass data through the component tree without manually passing props down at every level. It's useful for global data like themes, user settings, etc.

Example of Using Context:
```jsx
import React, { createContext, useContext } from 'react';

const ThemeContext = createContext('light');

function ThemeButton() {
  const theme = useContext(ThemeContext);
  return <button>{theme}</button>;
}

function App() {
  return (
    <ThemeContext.Provider value="dark">
      <ThemeButton />
    </ThemeContext.Provider>
  );
}

export default App;
```

### 12. **Higher-Order Components (HOCs)**

A **Higher-Order Component** is a function that takes a component and returns a new component. It's a pattern used to reuse component logic.

Example:
```jsx
function withExtraInfo(WrappedComponent) {
  return function EnhancedComponent(props) {
    return (
      <div>
        <WrappedComponent {...props} />
        <p>Additional Info</p>
      </div>
    );
  };
}
```

### 13. **React Fragments**

React **Fragments** allow you to group multiple elements without adding extra nodes to the DOM.

Example:
```jsx
function FragmentExample() {
  return (
    <>
      <h1>Title</h1>
      <p>Description</p>
    </>
  );
}
```

### 14. **Portals**

React **Portals** provide a way to render children into a DOM node that exists outside the DOM hierarchy of the parent component.

Example:
```jsx
import ReactDOM from 'react-dom';

function Modal() {
  return ReactDOM.createPortal(
    <div>Modal Content</div>,
    document.getElementById('modal-root')
  );
}
```

### 15. **Error Boundaries**

Error boundaries are components that catch JavaScript errors in their child component tree, log those errors, and display a fallback UI instead of crashing the whole app.

Example:
```jsx
class ErrorBoundary extends React.Component {
  constructor(props) {
    super(props);
    this.state = { hasError: false };
  }

  static getDerivedStateFromError() {
    return { hasError: true };
  }

  render() {
    if (this.state.hasError) {
      return <h1>Something went wrong.</h1>;
    }

    return this.props.children;
  }
}
```

---

### Conclusion

React offers a powerful and flexible ecosystem for building modern, efficient, and scalable web applications. By understanding components, state management, hooks, props, routing, and the other concepts outlined here, you can create sophisticated and dynamic user interfaces in a modular and maintainable way.
