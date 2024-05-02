import React from "react";
import Header from "./Header";
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
const categorys = [
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
    return (
        <>
            <Header />
            <div className="productListPage">
                <div>
                    <div class="container">
                        <div class="row">
                        <div className="col-md-3 categoryList">
                            <h2>Category</h2>
                            {categorys.map(category => (
                              <div> 
                                {category.name}
                              </div>  
                            ))}
                        </div>
                        <div className="col-md-9">
                            <h2>Product List</h2>
                            <div className="row">
                                {products.map(product => (
                                    <div class="col-md-3 productItem" key={product.id}>
                                        <span className="productPhoto"></span>
                                            <span>{product.name} {product.price} </span>
                                            <span></span>
                                        <div className="productBtn">
                                            <div className="btn btn-primary"> Voir l'article</div>
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
