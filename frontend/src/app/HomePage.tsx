import NavBar from './NavBar.tsx';
import SearchBar from './SearchBar.tsx';
import CategoriesMenu from './CategoriesMenu.tsx';

export default function HomePage() {
  return (
    <div className="home-page">
        <NavBar />
        <main>
            <SearchBar />
            <CategoriesMenu />
        </main>
    </div>
  )
}
