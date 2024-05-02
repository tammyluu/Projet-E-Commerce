import React from "react";
import Header from "./Header";
import { Link, useParams } from "react-router-dom";

// Je n'arrive pas a importer quand sa vien d'autre page
const products = [
    {
        "id": 1,
        "name": "T-shirt",
        "price": 15.99,
        "category-id": 1
    },
    {
        "id": 2,
        "name": "Pants",
        "price": 29.99,
        "category-id": 1
    },
    {
        "id": 3,
        "name": "Shoes",
        "price": 49.99,
        "category-id": 1
    },
    {
        "id": 4,
        "name": "Watch",
        "price": 99.99,
        "category-id": 2
    }
    ,
    {
        "id": 32,
        "name": "Shoes",
        "price": 49.99,
        "category-id": 1
    },{
        "id": 35,
        "name": "Shoes",
        "price": 49.99,
        "category-id": 1
    },{
        "id": 36,
        "name": "Shoes",
        "price": 49.99,
        "category-id": 1
    },{
        "id": 38,
        "name": "Shoes",
        "price": 49.99,
        "category-id": 1
    }
    
];
const categories = [
    {
        "id":1,
        "name": "Vetements"
    },
    {
        "id": 2,
        "name": "Accessoires"
    }
]

function ProductList() {
    
        const { id } = useParams();
      
        // Filtrer les produits par catégorie
        const filteredProducts = id
          ? products.filter(product => product["category-id"] == id)
          : products;
          
    return (
        <>
            <Header />
            <div className="productListPage">
                <div>
                    <div class="container">
                        <div class="row">
                        <div className="col-md-3 categoryList">
                        <h2>Category</h2>
                        <ul>
                        {categories.map(category => (
                            <li key={category.id}>
                            <Link to={`/category/${category.id}/products`}>{category.name}</Link>
                            </li>
                        ))}
                        </ul>
                            
                        </div>
                        <div className="col-md-9">
                            <h2>Product List</h2>
                            <div className="row">
                                {filteredProducts.map(product => (
                                    <div className="col-md-3 productItem" key={product.id}>
                                    <span className="productPhoto"></span>
                                    <span>{product.name} {product.price}</span>
                                    <div className="productBtn">
                                        <Link to={`/product/${product.id}`}>
                                         <div className="btn btn-primary"> Voir l'article</div>
                                        </Link>
                                        <div className="btn btn-success">+</div>
                                    </div>
                                    </div>
                                ))}
                            </div>
                        </div>    
                           
                        </div>
                    </div>
                        
                    
                </div>
            </div>
        </>
    );
}

export default ProductList;
